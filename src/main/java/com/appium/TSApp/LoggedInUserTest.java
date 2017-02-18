package com.appium.TSApp;

import org.junit.Assert;

import com.appium.TSApp.util.AppConnector;

import cucumber.api.java.en.Then;

public class LoggedInUserTest {
	
	AppConnector app = AppConnector.getInstance();
	
	@Then("I verify \"([^\"]*)\" is \"([^\"]*)\"$")
	public void I_verify_User(String loggedInUser, String EmailID ){
		
		Assert.assertEquals(app.config.getProperty(EmailID), app.getText(loggedInUser));
		}
	
	public void teardown() {
		app.appClose();
	}


}
