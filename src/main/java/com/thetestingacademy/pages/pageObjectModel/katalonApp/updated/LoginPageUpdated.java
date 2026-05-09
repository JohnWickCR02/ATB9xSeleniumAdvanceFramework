package com.thetestingacademy.pages.pageObjectModel.katalonApp.updated;

import com.thetestingacademy.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageUpdated extends CommonToAllPages {

    WebDriver driver;
    public LoginPageUpdated(WebDriver driver) {
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

        ///driver.findElement(userNameBox).sendKeys(userName);
        enterInputText(userNameBox,userName);
        //driver.findElement(passwordBox).sendKeys(password);
        enterInputText(passwordBox,password);

        //driver.findElement(loginBtn).click();
        clickElement(loginBtn);

        customWait(3);

        return driver.getCurrentUrl();
    }

    public String loginElementCheck() {

        return driver.findElement(validElement).getText();
    }

}
