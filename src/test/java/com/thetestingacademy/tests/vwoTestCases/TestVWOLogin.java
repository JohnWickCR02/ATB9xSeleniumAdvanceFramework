package com.thetestingacademy.tests.vwoTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class TestVWOLogin {

	@Description("test_negative_vwo_login")
	@Test
	public void test_negative_vwo_login() {
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get("https://app.vwo.com/#/login");
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

	WebElement emailInputBox =  driver.findElement(By.id("login-username"));
	
	emailInputBox.sendKeys("admin@email.com");
	
	WebElement passInputBox =  driver.findElement(By.name("password"));
	
	passInputBox.sendKeys("password");
	
	WebElement submitBtn =  driver.findElement(By.id("js-login-btn"));
	
	submitBtn.click();
	
	WebElement error_msg =  driver.findElement(By.className("notification-box-description"));
	
	wait.until(ExpectedConditions.textToBePresentInElement(error_msg, "Your email, password, IP address or location did not match"));
	
	Assert.assertEquals(error_msg.getText(), "Your email, password, IP address or location did not match");
	
	}
	
}
