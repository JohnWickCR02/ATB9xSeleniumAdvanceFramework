package com.thetestingacademy.pages.PageFactory;

import com.thetestingacademy.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPagePF extends CommonToAllPages {

    WebDriver driver;
    public ConfirmationPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[@class='lead']/preceding-sibling::h2")
    private WebElement cnfElement;
    @FindBy(id = "visit_date")
    private WebElement dateElement;

//    private By dateElement = By.id("visit_date");
//    private By cnfElement = By.xpath("//p[@class='lead']/preceding-sibling::h2");

    public String aptCnfText() {

        return fetchText(cnfElement);
    }

    public String checkDate() {

        return fetchText(dateElement);
    }

}
