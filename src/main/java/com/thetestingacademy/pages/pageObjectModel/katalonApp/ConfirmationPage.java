package com.thetestingacademy.pages.pageObjectModel.katalonApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    WebDriver driver;
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By dateElement = By.id("visit_date");
    private By cnfElement = By.xpath("//p[@class='lead']/preceding-sibling::h2");

    public String aptCnfText() {


        return driver.findElement(cnfElement).getText();
    }

    public String checkDate() {

        return driver.findElement(dateElement).getText();
    }

}
