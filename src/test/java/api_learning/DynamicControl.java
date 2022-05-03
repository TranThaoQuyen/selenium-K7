package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicControl {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //Navigate to target page
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");
            driver.manage().window().maximize();

            By checkoutFormSel = By.id("checkbox-example");
            By inputFormSel = By.id("input-example");

            //Checkbox form interaction
            WebElement checkboxFormEle = driver.findElement(checkoutFormSel);
            WebElement checkboxEle = checkboxFormEle.findElement(By.tagName("input"));
            if (!checkboxEle.isSelected()) {
                checkboxEle.click();
            }

            //Input form interaction
            WebElement inputFormElem = driver.findElement(inputFormSel);
            By inputElemSel = By.tagName("input");
            WebElement inputElem = inputFormElem.findElement(inputElemSel);
            WebElement inputBtnEle = inputFormElem.findElement(By.tagName("button"));
            if (!inputElem.isEnabled()) {
                inputBtnEle.click();
            }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
            inputElem.sendKeys("ABC-----------");
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
