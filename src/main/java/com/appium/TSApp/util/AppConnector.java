package com.appium.TSApp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppConnector {
	
	Properties OR = null;
	public Properties config = null;
	
	static AppConnector appConnector = null;
	
	AndroidDriver<AndroidElement> driver;
	
	private AppConnector() {
		
		
		if (OR == null || config == null) {
			OR = new Properties();
			config = new Properties();
			FileInputStream fis;
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\com\\appium\\TSApp\\config\\OR.properties");
				OR.load(fis);
				
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\com\\appium\\TSApp\\config\\config.properties");
				config.load(fis);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static AppConnector getInstance() {
		if (appConnector == null) {
			appConnector = new AppConnector();
		}
		
		return appConnector;
	}
	
	public void launchApp(String appName, String platform) throws MalformedURLException {
		File app = new File(System.getProperty("user.dir") + "\\apk\\" + config.getProperty(appName));
		
		String platformName = config.getProperty(platform);
		String deviceName = config.getProperty("Device");
		String platformVersion = config.getProperty("PlatformVersion");
		String url = config.getProperty("AppiumURL");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		cap.setCapability(MobileCapabilityType.APP, app);
		
		driver = new AndroidDriver<AndroidElement>(new URL(url), cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	public void type(String element, String text) {
		driver.findElement(By.id(OR.getProperty(element))).sendKeys(text);
	}
	
	
	public void click(String element) {
		driver.findElement(By.id(OR.getProperty(element))).click();
	}
	
	public void tap(String element) {
		driver.findElement(By.xpath(OR.getProperty(element))).tap(1, 2);;
	}
	
	public boolean verifyElementPresence(String element) {
		return (driver.findElements(By.id(OR.getProperty(element))).size() > 0);
	}
	
	public String getText(String element) {
		return driver.findElement(By.id(OR.getProperty(element))).getText();
	}
	
	public void doLogin(String emailId, String password) {
		driver.findElement(By.id(OR.getProperty("UserEmail"))).sendKeys(config.getProperty(emailId));
		driver.findElement(By.id(OR.getProperty("Password"))).sendKeys(config.getProperty(password));
		driver.findElement(By.id(OR.getProperty("SignInButton"))).click();
	}
	
	public void appClose() {
		driver.quit();
	}

}


