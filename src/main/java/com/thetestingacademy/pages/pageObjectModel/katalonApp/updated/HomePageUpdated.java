package com.thetestingacademy.pages.pageObjectModel.katalonApp.updated;

import com.thetestingacademy.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageUpdated extends CommonToAllPages {

    WebDriver driver;
    public HomePageUpdated(WebDriver driver) {
        this.driver = driver;
    }

    private By makeAptbtn = By.id("btn-make-appointment");

    public String navLogin() {

        //driver.get(PropertiesReader.readKey("url_katalon"));
        openURL();
        //driver.findElement(makeAptbtn).click();
        clickElement(makeAptbtn);

        customWait(3);

        return driver.getCurrentUrl();
    }
}
