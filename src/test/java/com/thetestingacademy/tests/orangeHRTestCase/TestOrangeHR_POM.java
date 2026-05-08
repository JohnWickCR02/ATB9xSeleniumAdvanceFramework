package com.thetestingacademy.tests.orangeHRTestCase;

import com.thetestingacademy.pages.pageObjectModel.orangeHR.EmployeeListHomePage;
import com.thetestingacademy.pages.pageObjectModel.orangeHR.LoginHR;
import com.thetestingacademy.pages.pageObjectModel.vwo.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOrangeHR_POM {

    @Owner("Jivi")
    @Description("Verify OrangeHR login and UserName")
    @Test
    public void testLoginPositiveVWO() {

        WebDriver driver = new ChromeDriver();
        LoginHR loginPage = new LoginHR(driver);

        loginPage.loginToHRCreds("admin", "Hacker@4321");

        EmployeeListHomePage employeeListHomePage = new EmployeeListHomePage(driver) ;
        String loggedInUserName = employeeListHomePage.LoggedInUserName();

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName, "PIM");

    }

}


