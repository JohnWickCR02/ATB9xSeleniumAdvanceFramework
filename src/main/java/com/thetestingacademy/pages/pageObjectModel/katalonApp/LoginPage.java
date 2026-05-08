package com.thetestingacademy.pages.pageObjectModel.katalonApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By etractUserName = By.xpath("//span[@id='demo_username_label']/following-sibling::input");
    private By etractPassword = By.xpath("//span[@id='demo_password_label']/following-sibling::input");
    private By userNameBox = By.id("txt-username");
    private By passwordBox = By.id("txt-password");
    private By loginBtn = By.id("btn-login");
    private By validElement = By.xpath("//div/h2");

    public String navBookAptPage()  {

        String userName = driver.findElement(etractUserName).getDomAttribute("value");
        String password = driver.findElement(etractPassword).getDomAttribute("value");

        driver.findElement(userNameBox).sendKeys(userName);
        driver.findElement(passwordBox).sendKeys(password);
//        System.out.println("User Name : " + userName);
//        System.out.println("Password : " + password);
        driver.findElement(loginBtn).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return driver.getCurrentUrl();
    }

    public String loginElementCheck() {

        return driver.findElement(validElement).getText();
    }

}
