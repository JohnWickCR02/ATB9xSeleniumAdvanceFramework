package com.thetestingacademy.tests.katalonAppCases;


import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.AppointmentPage;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.ConfirmationPage;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.HomePage;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.LoginPage;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.updated.AppointmentPageUpdated;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.updated.ConfirmationPageUpdated;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.updated.HomePageUpdated;
import com.thetestingacademy.pages.pageObjectModel.katalonApp.updated.LoginPageUpdated;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;

public class testKatalonApp_03 extends CommonToAllTest {


    @Owner("Jivi")
    @Description("TestCase to navigate to Login page and validate URL")
    @Test(priority = 1)
    public void navigateToLogin()
    {
        HomePageUpdated homePage = new HomePageUpdated(DriverManager.getDriver());

        String url = homePage.navLogin();

        Assert.assertEquals(url,"https://katalon-demo-cura.herokuapp.com/profile.php#login");

    }


    @Owner("Jivi")
    @Description("TestCase to land on appointment page")
    @Test(priority = 2)
    public void navigateToAppointment()
    {
        LoginPageUpdated loginPage = new LoginPageUpdated(DriverManager.getDriver());

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
