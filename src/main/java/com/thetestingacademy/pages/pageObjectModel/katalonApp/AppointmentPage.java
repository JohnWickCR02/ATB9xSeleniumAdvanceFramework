package com.thetestingacademy.pages.pageObjectModel.katalonApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentPage {

    WebDriver driver;
    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }


    private By dateBox = By.id("txt_visit_date");
    private By bookAptBtn = By.id("btn-book-appointment");



    public String bookApt(String date)  {

        driver.findElement(dateBox).sendKeys(date);

        driver.findElement(bookAptBtn).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return driver.getCurrentUrl();

    }

}
