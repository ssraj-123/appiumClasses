package com.calculator.demo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class DragAndDrop {

	// WebDriver driver;
	AndroidDriver<WebElement> driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "emulator-5554");
		capability.setCapability("platformName", "Android");
		capability.setCapability("appPackage", "com.mobeta.android.demodslv");
		capability.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
		// driver = new RemoteWebDriver(new
		// URL("http://0.0.0.0:4723/wd/hub"),capability);
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);
	}

	@Test()
	public void dragDrop() throws IOException {

		driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id='com.mobeta.android.demodslv:id/activity_title']"))
				.click();

		List<WebElement> elements = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));
		WebElement ele1 = elements.get(2);
		WebElement ele2 = elements.get(5);
		TouchAction ta = new TouchAction(driver);
		ta.longPress(ele1).moveTo(ele2).release().perform();
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Appium\\screenshot\\screen.png");
		FileUtils.copyFile(src, dest);
		Reporter.log("Screnshot Taken", true);
		//driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
		//to change orientation
		driver.rotate(ScreenOrientation.LANDSCAPE);
		driver.rotate(ScreenOrientation.PORTRAIT);
		

	}

	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}