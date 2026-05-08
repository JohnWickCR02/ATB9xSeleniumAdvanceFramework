package com.thetestingacademy.pages.pageObjectModel.orangeHR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListHomePage {

    WebDriver driver;

    public EmployeeListHomePage(WebDriver driver) {
        this.driver = driver;
    }

    By userNameOnDashBoard = By.xpath("//h6[normalize-space()='PIM']");

    public String LoggedInUserName() {

        try {
            Thread.sleep(5000);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return driver.findElement(userNameOnDashBoard).getText();

    }

}
