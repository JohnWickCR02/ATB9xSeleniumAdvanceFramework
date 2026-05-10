package com.thetestingacademy.pages.PageFactory;

import com.thetestingacademy.base.CommonToAllPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePF extends CommonToAllPages {

    WebDriver driver;
    public HomePagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //private By makeAptbtn = By.id("btn-make-appointment");
    @FindBy(id = "btn-make-appointment")
    private WebElement makeAptbtn;

    public String navLogin() {

        //driver.get(PropertiesReader.readKey("url_katalon"));
        openURL();
        //driver.findElement(makeAptbtn).click();
        clickElement(makeAptbtn);

        customWait(3);

        return driver.getCurrentUrl();
    }
}
