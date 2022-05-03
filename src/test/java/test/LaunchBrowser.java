package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {
        String currentProjectLocation = System.getProperty("user.dir");
        String relativeChromeDriverPath = "/src/test/resources/drivers/chromedriver.exe";
        String chromeDriverPath = currentProjectLocation.concat(relativeChromeDriverPath);
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://sdetpro.com/");
        driver.manage().window().maximize();

        //DEBUG PURPOSE ONLY
        Thread.sleep(3000);

        //QUIT SESSION
        driver.quit();
    }
}
