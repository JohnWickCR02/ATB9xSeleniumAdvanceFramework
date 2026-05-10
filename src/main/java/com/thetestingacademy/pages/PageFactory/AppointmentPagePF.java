package com.thetestingacademy.pages.PageFactory;

import com.thetestingacademy.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentPagePF extends CommonToAllPages {

    WebDriver driver;
    public AppointmentPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "txt_visit_date")
    private WebElement dateBox;
    @FindBy(id = "btn-book-appointment")
    private WebElement bookAptBtn;

//    private By dateBox = By.id("txt_visit_date");
//    private By bookAptBtn = By.id("btn-book-appointment");



    public String bookApt(String date)  {

        //driver.findElement(dateBox).sendKeys(date);
        enterInputText(dateBox,date);

        clickElement(bookAptBtn);

        customWait(3);

        return driver.getCurrentUrl();

    }

}
