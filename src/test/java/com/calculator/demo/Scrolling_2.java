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
import io.appium.java_client.android.AndroidKeyCode;

public class Scrolling_2 {

	AndroidDriver<WebElement> driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "emulator-5554");
		capability.setCapability("platformName", "Android");
		capability.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");
		capability.setCapability("appActivity",
				"com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);
	}

	@Test(enabled = false)
	public void ApiDemoPractice() {

		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		Dimension size = driver.manage().window().getSize();

		int height = size.getHeight();
		System.out.println(height);
		int width = size.getWidth();

		int starty = (int) (height / 2);

		int startx = (int) (width * 0.80);
		int endx = (int) (width * 0.20);
		driver.swipe(startx, starty, endx, starty, 3000);
	}

	@Test(enabled = true)
	public void ApiDemoPractice1() {

		TouchAction touchAction = new TouchAction(driver);
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		Dimension size = driver.manage().window().getSize();

		int height = size.getHeight();
		int width = size.getWidth();

		int x1 = (int) (width * 0.20);
		int x2 = (int) (width * 0.90);
		
		WebElement ele1 = (WebElement) driver.findElementById("com.fortysevendeg.android.swipelistview:id/example_row_b_action_3");

		touchAction.longPress(ele1).moveTo(x1,200).release().perform();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);


		
		//driver.swipe(startx, starty, endx, starty, 3000);
	}

}
