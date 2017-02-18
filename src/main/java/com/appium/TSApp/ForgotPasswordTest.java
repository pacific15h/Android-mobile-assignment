package com.appium.TSApp;


import java.util.List;

import org.junit.Assert;

import com.appium.TSApp.util.AppConnector;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ForgotPasswordTest {
	
	AppConnector app = AppConnector.getInstance();
	
	@And("^I have forgotten password$")
	public void I_forgot(){
		System.out.println("Forgot Password");
	}
	
	
	@Then("^I see elements$")
	public void Then_I_See(DataTable dt){
		
		List <String> elements = dt.asList(String.class);
		
		for (String element : elements) {
		Assert.assertTrue(app.verifyElementPresence(element));
		}
		}
	
	public void teardown() {
		app.appClose();
	}

}

