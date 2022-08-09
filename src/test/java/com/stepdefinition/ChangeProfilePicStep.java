package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.ChangeProfilePic_Output_pojo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;

/**
 * 
 * @author Suresh Kumar G
 * @Description To contains change profile picture snippets
 * @CreationDate 27/06/2022
 */
public class ChangeProfilePicStep extends BaseClass {
	/**
	 * @Description Change profile picture step User add headers,bearer
	 *              authorization and multiPart for accessing upload profile picture
	 * @CreationDate 27/06/2022
	 */
	@Given("User add headers,bearer authorization and multiPart for accessing upload profile picture")
	public void userAddHeadersBearerAuthorizationAndMultiPartForAccessingUploadProfilePicture() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "multipart/form-data");
		Header h2 = new Header("Authorization", "Bearer " + LoginStep.CommonVariables.getLogToken());
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);

	}

	/**
	 * 
	 * @throws Exception
	 * @Description Change profile picture step User add multipart for upload
	 *              profile picture
	 * @CreationDate 27/06/2022
	 */
	@When("User add multipart for upload profile pic")
	public void userAddMultipartForUploadProfilePic() throws Exception {
		multipart(getPropertyFileValue("path"));
	}

	/**
	 * 
	 * @param requestType
	 * @Description Change profile picture step User send request to change
	 *              ProfilePic endpoint profile picture
	 * @CreationDate 27/06/2022
	 */
	@When("User send {string} request to change ProfilePic endpoints")
	public void userSendRequestToChangeProfilePicEndpoints(String requestType) {
		response = requestType(requestType, Endpoints.CHANGEPROFILEPIC);

	}

	/**
	 * 
	 * @param string
	 * @Description Change profile picture step User verify change profile pic
	 *              response message
	 * @CreationDate 27/06/2022
	 */
	@Then("User verify change profile pic response message matches {string}")
	public void userVerifyChangeProfilePicResponseMessageMatches(String actualMessage) {
		ChangeProfilePic_Output_pojo changeProfilePic_Output_pojo = response.as(ChangeProfilePic_Output_pojo.class);
		String expectedMessage = changeProfilePic_Output_pojo.getMessage();
		System.out.println("Response message : " + expectedMessage);
		Assert.assertEquals("Verify response message", expectedMessage, actualMessage);
	}

}
