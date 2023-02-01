package com.testvagrant.utils;

import com.testvagrant.logger.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browsers extends BrowserAbstract {

    private static final CustomLogger LOGGER = new CustomLogger(Browsers.class);

    @Override
    public void setDriver(String myBrowser) {
        // TODO Auto-generated method stub
        WebDriver driver = null;
        switch (myBrowser) {
            case "chrome":
				WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-notifications");
				chromeOptions.addArguments("--start-maximized");
				driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setAcceptInsecureCerts(true);
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalStateException("Browser is not supported");
        }
        setWebDriver(driver);
    }

    @Override
    public void closeDriver() {
        // TODO Auto-generated method stub
        getDriver().quit();
    }

}
