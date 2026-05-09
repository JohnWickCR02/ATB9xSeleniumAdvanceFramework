package com.thetestingacademy.pages.pageObjectModel.katalonApp.updated;

import org.openqa.selenium.By;
import com.thetestingacademy.base.CommonToAllPages;
import org.openqa.selenium.WebDriver;

public class ConfirmationPageUpdated extends CommonToAllPages {

    WebDriver driver;
    public ConfirmationPageUpdated(WebDriver driver) {
        this.driver = driver;
    }

    private By dateElement = By.id("visit_date");
    private By cnfElement = By.xpath("//p[@class='lead']/preceding-sibling::h2");

    public String aptCnfText() {

        return fetchText(cnfElement);
    }

    public String checkDate() {

        return fetchText(dateElement);
    }

}
