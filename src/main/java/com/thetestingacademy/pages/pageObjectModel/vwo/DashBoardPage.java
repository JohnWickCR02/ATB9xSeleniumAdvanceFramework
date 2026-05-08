package com.thetestingacademy.pages.pageObjectModel.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {

    WebDriver driver;
    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By username = By.cssSelector("[data-qa='lufexuloga']");

    public String loggedInUserName(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return driver.findElement(username).getText() ;
    }



}
