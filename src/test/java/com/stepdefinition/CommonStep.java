package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Suresh Kumar G
 * @Description To contains common snippets
 * @CreationDate 27/06/2022
 */
public class CommonStep extends BaseClass {
	/**
	 * 
	 * @param statusCode
	 * @Description Common step User verify status code
	 * @CreationDate 27/06/2022
	 */
	@Then("User verify status code is {int}")
	public void userVerifyStatusCodeIs(int actualStatuscode) {
		int expectedStatusCode = getStatusCode(response);
		System.out.println("Status Code : " + expectedStatusCode);
		LoginStep.CommonVariables.setStstusCode(expectedStatusCode);
		Assert.assertEquals("verify ststus code", LoginStep.CommonVariables.getStstusCode(), actualStatuscode);

	}

}
