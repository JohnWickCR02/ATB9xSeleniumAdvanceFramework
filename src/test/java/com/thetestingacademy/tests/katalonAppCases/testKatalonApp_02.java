package com.thetestingacademy.tests.katalonAppCases;


import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.AppointmentPage;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.ConfirmationPage;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.HomePage;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.LoginPage;

import com.thetestingacademy.driver.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;

public class testKatalonApp_02 extends CommonToAllTest {


//    WebDriver driver;
//
//    @BeforeClass
//    public void setUpBrowser() {
//        ChromeOptions  options = new ChromeOptions();
//        options.addArguments("--incognito");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//    }


    @Owner("Jivi")
    @Description("TestCase to navigate to Login page and validate URL")
    @Test(priority = 1)
    public void navigateToLogin()
    {
        HomePage homePage = new HomePage(DriverManager.getDriver());

        String url = homePage.navLogin();

        Assert.assertEquals(url,"https://katalon-demo-cura.herokuapp.com/profile.php#login");

    }


    @Owner("Jivi")
    @Description("TestCase to land on appointment page")
    @Test(priority = 2)
    public void navigateToAppointment()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());

        String successLoginText = loginPage.loginElementCheck();
        String url = loginPage.navBookAptPage();

        Assert.assertEquals(url,"https://katalon-demo-cura.herokuapp.com/#appointment");

        Assert.assertEquals(successLoginText,"Login");


    }


    @Owner("Jivi")
    @Description("TestCase to make Appintment validate URL")
    @Test(priority = 3)
    public void makeAppointment()
    {

        AppointmentPage appointmentPage = new AppointmentPage(DriverManager.getDriver());

        String date = PropertiesReader.readKey("date_katalon");
        String url = appointmentPage.bookApt(date);

        Assert.assertEquals(url,"https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

    }

    @Owner("Jivi")
    @Description("TestCase to confirm appointment")
    @Test(priority = 4)
    public void confirmAppointment()
    {
        ConfirmationPage cnfPage = new ConfirmationPage(DriverManager.getDriver());

        String valid_Text = cnfPage.aptCnfText();
        String valid_Date = cnfPage.checkDate();
        String date = PropertiesReader.readKey("date_katalon");

        Assert.assertEquals(valid_Text,"Appointment Confirmation");

        Assert.assertEquals(valid_Date,date);

    }

}
