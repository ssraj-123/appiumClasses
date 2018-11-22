package com.calculator.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class GoogleSearch {
	AndroidDriver<WebElement> driver;
	
	@BeforeTest
	public void setUP() throws MalformedURLException {
		DesiredCapabilities cap= new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		driver= new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			
	}
	
	@Test
	public void method1() {
		
	}

}
