package com.thetestingacademy.tests.sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class TestSample {

	
	@Description("Sample TC1")
	@Test
	public void testSample0 () {
		
		Assert.assertTrue(true);
		
	}
	
	@Description("Sample TC2")
	@Test
	public void testSample1 () {
		
		Assert.assertTrue(true);
		
	}
	
	
}
