package com.thetestingacademy.pages.pageObjectModel.orangeHR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHR {

    WebDriver driver;
    public LoginHR(WebDriver driver) {
    this.driver = driver;

    }

    private By userName = By.xpath("//input[@name='username']");

    private By pass = By.xpath("//input[@name='password']");

    private By SignInBtn = By.xpath("//button[normalize-space()='Login']");


    public void loginToHRCreds(String username, String pwd) {

        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        try {
            Thread.sleep(3000);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(userName).sendKeys(username);
        driver.findElement(pass).sendKeys(pwd);
        driver.findElement(SignInBtn).click();

        try {
            Thread.sleep(3000);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
