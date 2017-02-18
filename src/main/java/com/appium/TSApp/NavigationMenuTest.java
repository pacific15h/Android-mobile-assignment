package com.appium.TSApp;

import org.junit.Assert;

import com.appium.TSApp.util.AppConnector;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class NavigationMenuTest {
	
	AppConnector app = AppConnector.getInstance();
	
	@Given("^I am logged in app$")
	public void I_Looged_In(){
		System.out.println("Check logged in or not");
		
		if (!app.verifyElementPresence("AppToolbar")) {
			System.out.println("Check logged in or not");
			app.doLogin("EmailId", "Password");
		}
		
	}
	
	
	@Then("Side \"([^\"]*)\" opens$")
	public void Menu_Opens(String element){
		
		Assert.assertTrue(app.verifyElementPresence(element));
		}
	
	public void teardown() {
		app.appClose();
	}


}

