package com.thetestingacademy.pages.PageFactory;

import com.thetestingacademy.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePF extends CommonToAllPages {

    WebDriver driver;
    public LoginPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@id='demo_username_label']/following-sibling::input")
    private WebElement etractUserName;
    @FindBy(xpath = "//span[@id='demo_password_label']/following-sibling::input")
    private WebElement etractPassword;
    @FindBy(xpath = "//div/h2")
    private WebElement validElement;
    @FindBy(id = "txt-username")
    private WebElement userNameBox;
    @FindBy(id = "txt-password")
    private WebElement passwordBox;
    @FindBy(id = "btn-login")
    private WebElement loginBtn;
//    private By etractUserName = By.xpath("//span[@id='demo_username_label']/following-sibling::input");
//    private By etractPassword = By.xpath("//span[@id='demo_password_label']/following-sibling::input");
//    private By userNameBox = By.id("txt-username");
//    private By passwordBox = By.id("txt-password");
//    private By loginBtn = By.id("btn-login");
//    private By validElement = By.xpath("//div/h2");

    public String navBookAptPage()  {

        String userName = etractUserName.getDomAttribute("value");
        String password = etractPassword.getDomAttribute("value");

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

        return validElement.getText();
    }

}
