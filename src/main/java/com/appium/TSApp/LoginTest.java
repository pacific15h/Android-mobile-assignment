package com.appium.TSApp;



import org.junit.Assert;

import com.appium.TSApp.util.AppConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

//step layer
public class LoginTest {
	
	AppConnector app = AppConnector.getInstance();
	
	@And("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void I_enter(String element,String text){
		System.out.println("Entering in "+ element +" value "+ text);
		app.type(element, text);
	}
	
	// clicking on object
	@And("^I click on \"([^\"]*)\"$")
	public void I_Click_On(String element){
		app.click(element);
	}
	
	
	@Then("^Login is \"([^\"]*)\" on appearance of \"([^\"]*)\"$")
	public void Then_login_is(String expectedResult, String element){
		String actualResult = null;
		if (app.verifyElementPresence(element)) {
			actualResult = "Success";
		}
		else {
			actualResult = "Failure";
		}
		System.out.println("Login - "+ expectedResult);
		
		Assert.assertEquals(expectedResult, actualResult);
		}
	
	public void teardown() {
		app.appClose();
	}
	

}
