package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payload.Payload;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_pojo;
import com.pojo.DeleteAddress_Input_pojo;
import com.pojo.DeleteAddress_Output_pojo;
import com.pojo.GetAddress_Output_pojo;
import com.pojo.UpdateAddress_Input_pojo;
import com.pojo.UpdateAddress_Output_pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;

/**
 * 
 * @author Suresh Kumar G
 * @Description To contains address snippets
 * @CreationDate 27/06/2022
 *
 */
public class AddressStep extends BaseClass {

	/**
	 * @Description address step User add headers and bearer authorization for
	 *              accessing address endpoint
	 * @CreationDate 27/06/2022
	 */
	@Given("User add headers and bearer authorization for accessing address endpoints")
	public void userAddHeadersAndBearerAuthorizationForAccessingAddressEndpoints() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginStep.CommonVariables.getLogToken());
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);

	}

	/**
	 * 
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @Description address step user add request body for add new address
	 * @CreationDate 27/06/2022
	 * 
	 */
	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void userAddRequestBodyForAddNewAddress(String first_name, String last_name, String mobile, String apartment,
			String state, String city, String country, String zipcode, String address, String address_type) {
		AddAddress_Input_pojo createAddress = Payload.createAddress(first_name, last_name, mobile, apartment,
				Integer.parseInt(state), Integer.parseInt(city), Integer.parseInt(country), zipcode, address,
				address_type);
		addBody(createAddress);

	}

	/**
	 * 
	 * @param requestType
	 * @Description address step user send request for address endpoint
	 * @CreationDate 27/06/2022
	 */
	@When("User send {string} request for add new address endpoint")
	public void userSendRequestForAddNewAddressEndpoint(String requestType) {

		response = requestType(requestType, Endpoints.ADDADDRESS);

	}

	/**
	 * 
	 * @param actualMeaasge
	 * @Description address step user verify create address response message
	 * @CreationDate 27/06/2022
	 */
	@Then("User verify create address response message matches {string}")
	public void userVerifyCreateAddressResponseMessageMatches(String actualMeaasge) {
		AddAddress_Output_pojo addAddress_Output_pojo = response.as(AddAddress_Output_pojo.class);
		String expectedMessage = addAddress_Output_pojo.getMessage();
		System.out.println("Response message : " + expectedMessage);
		int id = addAddress_Output_pojo.getAddress_id();
		String addressId = String.valueOf(id);
		System.out.println("Response aaaress_id : " + addressId);
		LoginStep.CommonVariables.setAddressId(addressId);
		Assert.assertEquals("Verify response message", expectedMessage, actualMeaasge);

	}

	/**
	 * 
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @Description address step user add request body for update existing address
	 * @CreationDate 27/06/2022
	 */
	@When("User add request body for update existing address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void userAddRequestBodyForUpdateExistingAddress(String first_name, String last_name, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {

		UpdateAddress_Input_pojo updateAddress = Payload.updateAddress(LoginStep.CommonVariables.getAddressId(),
				first_name, last_name, mobile, apartment, Integer.parseInt(state), Integer.parseInt(city),
				Integer.parseInt(country), zipcode, address, address_type);
		addBody(updateAddress);

	}

	/**
	 * 
	 * @param requestType
	 * @Description address step user send request for address endpoint
	 * @CreationDate 27/06/2022
	 */
	@When("User send {string} request for update existing address endpoint")
	public void userSendRequestForUpdateExistingAddressEndpoint(String requestType) {
		response = requestType(requestType, Endpoints.UPDATEADDRESS);
	}

	/**
	 * 
	 * @param actualMessage
	 * @Description address step user verify update address response message
	 * @CreationDate 27/06/2022
	 */
	@Then("User verify update address response message matches {string}")
	public void userVerifyUpdateAddressResponseMessageMatches(String actualMessage) {
		UpdateAddress_Output_pojo updateAddress_Output_pojo = response.as(UpdateAddress_Output_pojo.class);
		String expectedMessage = updateAddress_Output_pojo.getMessage();
		System.out.println("Response message : " + expectedMessage);
		Assert.assertEquals("Verify response Message", expectedMessage, actualMessage);
	}

	/**
	 * 
	 * @param requestType
	 * @Description address step user send request for address endpoint
	 * @CreationDate 27/06/2022
	 */
	@When("User send {string} request for get existing address endpoint")
	public void userSendRequestForGetExistingAddressEndpoint(String requestType) {
		response = requestType(requestType, Endpoints.GETADDRESS);
	}

	/**
	 * 
	 * @param actualMessage
	 * @Description address step user verify get address response ststus
	 * @CreationDate 27/06/2022
	 */
	@Then("User verify get address response ststus matches {string}")
	public void userVerifyGetAddressResponseStstusMatches(String actualMessage) {
		GetAddress_Output_pojo getAddress_Output_pojo = response.as(GetAddress_Output_pojo.class);
		String expectedMessage = getAddress_Output_pojo.getMessage();
		System.out.println("Response message : " + expectedMessage);
		Assert.assertEquals("Verify response Message", expectedMessage, actualMessage);
	}

	/**
	 * @Description address step user add request body for delete address
	 * @CreationDate 27/06/2022
	 */
	@When("User add request body for delete address")
	public void userAddRequestBodyForDeleteAddress() {
		DeleteAddress_Input_pojo deleteAddress = Payload.deleteAddress(LoginStep.CommonVariables.getAddressId());
		addBody(deleteAddress);
	}

	/**
	 * 
	 * @param requestType
	 * @Description address step user send request for address endpoint
	 * @CreationDate 27/06/2022
	 */
	@When("User send {string} request for delete existing address endpoint")
	public void userSendRequestForDeleteExistingAddressEndpoint(String requestType) {

		response = requestType(requestType, Endpoints.DELETEADDRESS);

	}

	/**
	 * 
	 * @param actualMessage
	 * @Description address step user verify delete address response message
	 * @CreationDate 27/06/2022
	 */
	@Then("User verify delete address response message matches {string}")
	public void userVerifyDeleteAddressResponseMessageMatches(String actualMessage) {
		DeleteAddress_Output_pojo deleteAddress_Output_pojo = response.as(DeleteAddress_Output_pojo.class);
		String expectedMessage = deleteAddress_Output_pojo.getMessage();
		System.out.println("Response message : " + expectedMessage);
		Assert.assertEquals("Verify response message", expectedMessage, actualMessage);

	}

}
