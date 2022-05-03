package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginForm {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //Navigate to target page
            driver.get("https://the-internet.herokuapp.com/login");
            driver.manage().window().maximize();

            //Define locator
            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginBtnSel = By.cssSelector("[type = 'submit']");

            //Find Element
            WebElement username = driver.findElement(usernameSel);
            WebElement password = driver.findElement(passwordSel);
            WebElement loginBtn = driver.findElement(loginBtnSel);

            //Interact with Element
            username.sendKeys("tomsmith");
            password.sendKeys("SuperSecretPassword!");
            loginBtn.click();

            //------on the next page------
            printTitleAndURL(driver);

            //Find th h4 tag
            By welcomeTextSel = By.cssSelector("h4");
            WebElement welcomeText = driver.findElement(welcomeTextSel);
            System.out.println("\t ---->" + welcomeText.getText());

            //Go back to the login page
            driver.navigate().back();
            printTitleAndURL(driver);

            //Multiple matching element
            List<WebElement> loginInputElems = driver.findElements(By.tagName("input"));
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            username = loginInputElems.get(USERNAME_INDEX);
            username.clear();
            username.sendKeys("teo");
            loginInputElems.get(PASSWORD_INDEX).sendKeys("password");

            loginBtn = driver.findElement(loginBtnSel);
            loginBtn.click();

            //Find the footer Powered by Link text
            By poweredByLinkTextSel = By.linkText("Elemental Selenium");
            WebElement poweredLinkText = driver.findElement(poweredByLinkTextSel);
            System.out.println("poweredLinkText: " + poweredLinkText.getText());

            //Get flash error msg
            By loginMsgSel = By.cssSelector(".error");
            WebElement loginMsgEle = driver.findElement(loginMsgSel);
            String loginMsgBackgroundColor = loginMsgEle.getCssValue("background-color");
            System.out.println("loginMsgBackgroundColor: " + loginMsgBackgroundColor);

            //DEBUG PURPOSE ONLY
            Thread.sleep(2000);




        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }



    }

    private static void printTitleAndURL(WebDriver driver){
        System.out.println("\t ---->" + driver.getTitle());
        System.out.println("\t ---->" + driver.getCurrentUrl());

    }
}
