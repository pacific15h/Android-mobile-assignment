package com.appium.TSApp;

/****************** Common step definition ******************************/

import java.net.MalformedURLException;

import com.appium.TSApp.util.AppConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CommonDefs {
	
	AppConnector app = AppConnector.getInstance();
	
	@Given("^I go to \"([^\"]*)\" on \"([^\"]*)\"$")
	public void I_Go_To_App(String appName, String platform) throws MalformedURLException{
		System.out.println("I am going to "+ appName +" on  "+ platform);
		
		app.launchApp(appName, platform);
		
	}
	
	// taps on object
	@And("^I tap on \"([^\"]*)\"$")
	public void I_Tap_On(String element){
		app.tap(element);
	}

}
