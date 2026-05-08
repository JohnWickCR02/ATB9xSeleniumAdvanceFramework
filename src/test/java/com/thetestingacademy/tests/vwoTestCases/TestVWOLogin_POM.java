package com.thetestingacademy.tests.vwoTestCases;

import com.thetestingacademy.pages.pageObjectModel.vwo.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_POM {

    @Owner("Jivi")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {

        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        String error_msg = loginPage.loginToVwoLoginInvalidCreds("admin@gmail.com","1234");

        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");

    }

    @Owner("Jivi")
    @Description("Verify that valid creds give error message")
    @Test
    public void testLoginPositiveVWO() {

        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        String error_msg = loginPage.loginToVwoLoginValidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");

        DashBoardPage dashBoardPage = new DashBoardPage(driver);

        String loggedInUserName = dashBoardPage.loggedInUserName();

    }

}
