package com.calculator.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CalculationDemo {

	WebDriver driver;
	@BeforeTest
	public void setUp() throws MalformedURLException {
		
		DesiredCapabilities capability= new DesiredCapabilities();
		capability.setCapability("deviceName", "emulator-5554");
		capability.setCapability("platformName", "Android");
		capability.setCapability("appPackage", "com.android.calculator2");
		capability.setCapability("appActivity", "com.android.calculator2.Calculator");
		driver= new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		
	}

	@Test
	public void method() {
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/digit_8']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/op_add']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/digit_5']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/eq']")).click();
		String value=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.android.calculator2:id/result']")).getText();
		Reporter.log(value, true);
		String act="13";
		Assert.assertEquals(value, act);
		Reporter.log("Test case passed", true);
		
	}

	@AfterTest
	public void tearDown() {

	}
}
