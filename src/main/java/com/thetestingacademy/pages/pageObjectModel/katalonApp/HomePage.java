package com.thetestingacademy.pages.pageObjectModel.katalonApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By makeAptbtn = By.id("btn-make-appointment");

    public String navLogin() {

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(makeAptbtn).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.getCurrentUrl();
    }
}
