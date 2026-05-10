package com.thetestingacademy.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.PropertiesReader;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class CommonToAllPages {

    public void openURL(){
        getDriver().navigate().to(PropertiesReader.readKey("url_katalon"));
    }

    public void clickElement(By by) {
    getDriver().findElement(by).click();
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void enterInputText(By by , String text) {
    getDriver().findElement(by).sendKeys(text);
}

    public void enterInputText(WebElement element , String text) {
        element.sendKeys(text);
    }

    public String fetchText(By by) {
       return getDriver().findElement(by).getText();
    }

    public String fetchText(WebElement element
    ) {
        return element.getText();
    }

    public void customWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
