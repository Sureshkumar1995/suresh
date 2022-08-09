package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.CommonVariables;
import com.pojo.Login_Output_pojo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author Suresh Kumar G
 * @Description To contains login snippets
 * @CreationDate 27/06/2022
 */
public class LoginStep extends BaseClass {
	public static CommonVariables CommonVariables = new CommonVariables();

	/**
	 * @Description Login step user add header
	 * @CreationDate 27/06/2022
	 */
	@Given("User add header")
	public void userAddHeader() {

		addHeader("Content-Type", "application/json");

	}

	/**
	 * 
	 * @throws Exception
	 * @Description Login step user add basic authentication
	 * @CreationDate 27/06/2022
	 */
	@Given("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws Exception {

		basicAuth(getPropertyFileValue("username"), getPropertyFileValue("password"));

	}

	/**
	 * 
	 * @param loginRequest
	 * @Description Login step user send request for login endpoint
	 * @CreationDate 27/06/2022
	 */
	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String requestType) {

		response = requestType(requestType, Endpoints.LOGIN);

	}

	/**
	 * 
	 * @param first_name
	 * @Description Login step user verify login response body firstName
	 * @CreationDate 27/06/2022
	 */
	@Then("User verify login response body firstName present as {string} and get logtoken")
	public void userVerifyLoginResponseBodyFirstNamePresentAsAndGetLogtoken(String actualFirst_name) {

		Login_Output_pojo login_Output_pojo = response.as(Login_Output_pojo.class);
		String expectedFirstName = login_Output_pojo.getData().getFirst_name();
		System.out.println("Response first_name : " + expectedFirstName);
		String logtoken = login_Output_pojo.getData().getLogtoken();
		System.out.println("Response Logtoken : " + logtoken);
		CommonVariables.setLogToken(logtoken);
		Assert.assertEquals("verify first_name", expectedFirstName, actualFirst_name);

	}

}
