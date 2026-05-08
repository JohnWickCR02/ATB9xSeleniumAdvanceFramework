package com.thetestingacademy.pages.pageObjectModel.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // Page Class
    //Page Loocatoor

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // step 1 - page locators
    private By emailInputBox = By.xpath("//input[@id='login-username']");

    private By passInputBox = By.name("password");

    private By signInBtn = By.id("js-login-btn");

    private By error_msg = By.className("notification-box-description");


    // step 2 - page actions

    public String loginToVwoLoginInvalidCreds(String username, String pass) {
   driver.get("https://app.vwo.com/#/login");
   driver.findElement(emailInputBox).sendKeys(username);
   driver.findElement(passInputBox).sendKeys(pass);
   driver.findElement(signInBtn).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String error_msg_text = driver.findElement(error_msg).getText();

        return error_msg_text;
    }


    public String loginToVwoLoginValidCreds(String username, String pass) {
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(emailInputBox).sendKeys(username);
        driver.findElement(passInputBox).sendKeys(pass);
        driver.findElement(signInBtn).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return username;
    }

}