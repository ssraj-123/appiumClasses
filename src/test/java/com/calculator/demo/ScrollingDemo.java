package com.calculator.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class ScrollingDemo {

	AndroidDriver<WebElement> driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "emulator-5554");
		capability.setCapability("platformName", "Android");
		capability.setCapability("appPackage", "com.example.android.apis");
		capability.setCapability("appActivity", "com.example.android.apis.ApiDemos");
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);
	}

	@Test(enabled=false)
	public void ApiDemoPractice() {
	 TouchAction action = new TouchAction(driver);
	 
	 driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
	 WebElement  ele1= driver.findElement(By.xpath("//android.widget.TextView[@text='Grid']"));
	 WebElement  ele2= driver.findElement(By.xpath("//android.widget.TextView[@text='Auto Complete']"));
	 //process 1
     //action.press(ele1).moveTo(ele2).release().perform();
	 
	 //process 2
	 int x=ele1.getLocation().getX();
	 int y=ele1.getLocation().getY();
	 action.press(x,y).waitAction(4000).moveTo(x,y-800).release().perform();
	}
	
	@Test(enabled=true)
	public void scrolling() throws InterruptedException {
	 
	 driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
	 Thread.sleep(3000);
	 Dimension size = driver.manage().window().getSize();
	 
	 int height = size.getHeight();
	 int width = size.getWidth();
	 System.out.println(height);
	 System.out.println(width);
	 
	 int starty = (int) (height*0.80);
	 int endy= (int)(height*0.20);
	 int startx =(int)(width/2);
	 
	 driver.swipe(startx, starty, startx, endy, 3000);
	}
	
	
}
