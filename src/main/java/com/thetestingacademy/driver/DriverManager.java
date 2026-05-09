package com.thetestingacademy.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.PropertiesReader;

public class DriverManager {

   public static WebDriver driver;

   public static WebDriver getDriver() {
       return driver;
   }

   public static void setDriver(WebDriver driver) {
       DriverManager.driver= driver ;
   }

    public static void init() {

    String browser = PropertiesReader.readKey("browser");
    browser = browser.toLowerCase();
    if (driver==null) {
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--incognito");
                driver =  new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    firefoxOptions.addArguments("--incognito");
                    driver =  new FirefoxDriver(firefoxOptions);
                    break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--incognito");
                driver =  new EdgeDriver(edgeOptions);
                break;

            default:
                driver = new ChromeDriver();
                break;

        }
    }
}

    public static void down () {
    if(driver!= null) {
        driver.quit();
        driver = null ;
    }

}

}
