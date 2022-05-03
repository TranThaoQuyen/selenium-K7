package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getChromeDriver(){
        String currentProjectLocation = System.getProperty("user.dir");
        String macOSChromePath = "/src/test/resources/drivers/chromedriver.exe";
        String windowChromePath = "\\src\\test\\resources\\drivers\\chromedriver.exe";
        String relativeChromeDriverPath = OS.isFamilyMac() ? macOSChromePath : windowChromePath;
        String chromeDriverPath = currentProjectLocation.concat(relativeChromeDriverPath);
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        chromeOptions.addArguments("--incognito");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));

        return driver;

    }

}
