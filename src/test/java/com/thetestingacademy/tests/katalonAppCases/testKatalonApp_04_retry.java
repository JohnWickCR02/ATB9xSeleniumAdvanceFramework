package com.thetestingacademy.tests.katalonAppCases;


import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.listeners.RetryAnalyzer;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.updated.AppointmentPageUpdated;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.updated.ConfirmationPageUpdated;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.updated.HomePageUpdated;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.updated.LoginPageUpdated;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class testKatalonApp_04_retry extends CommonToAllTest {

    final static Logger logger = LogManager.getLogger(testKatalonApp_04_retry.class);

    @Owner("Jivi")
    @Description("TestCase to navigate to Login page and validate URL")
    @Test(priority = 1)
    public void navigateToLogin()
    {
        logger.info("Start navigating to Login page");

        HomePageUpdated homePage = new HomePageUpdated(DriverManager.getDriver());

        String url = homePage.navLogin();

        Assert.assertEquals(url,"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        ///////// FAILING
        Assert.fail("failing TC");

        logger.info("End navigating to Login page");
    }


    @Owner("Jivi")
    @Description("TestCase to land on appointment page")
    @Test(priority = 2)
    public void navigateToAppointment()
    {
        logger.info("Start navigating to Appointment page");

        LoginPageUpdated loginPage = new LoginPageUpdated(DriverManager.getDriver());

        String successLoginText = loginPage.loginElementCheck();
        String url = loginPage.navBookAptPage();

        Assert.assertEquals(url,"https://katalon-demo-cura.herokuapp.com/#appointment");

        Assert.assertEquals(successLoginText,"Login");

        logger.info("End navigating to Appointment page");
    }


    @Owner("Jivi")
    @Description("TestCase to make Appintment validate URL")
    @Test(priority = 3)
    public void makeAppointment()
    {
        logger.info("Start making Appointment page");
        AppointmentPageUpdated appointmentPage = new AppointmentPageUpdated(DriverManager.getDriver());

        String date = PropertiesReader.readKey("date_katalon");
        String url = appointmentPage.bookApt(date);

        Assert.assertEquals(url,"https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

    }

    @Owner("Jivi")
    @Description("TestCase to confirm appointment")
    @Test(priority = 4)
    public void confirmAppointment()
    {
        ConfirmationPageUpdated cnfPage = new ConfirmationPageUpdated(DriverManager.getDriver());

        String valid_Text = cnfPage.aptCnfText();
        String valid_Date = cnfPage.checkDate();
        String date = PropertiesReader.readKey("date_katalon");

        Assert.assertEquals(valid_Text,"Appointment Confirmation");

        Assert.assertEquals(valid_Date,date);

    }

}
