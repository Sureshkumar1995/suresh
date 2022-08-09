package com.omr.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_pojo;
import com.pojo.ChangeProfilePic_Output_pojo;
import com.pojo.DeleteAddress_Input_pojo;
import com.pojo.DeleteAddress_Output_pojo;
import com.pojo.GetAddress_Output_pojo;
import com.pojo.Login_Output_pojo;
import com.pojo.UpdateAddress_Input_pojo;
import com.pojo.UpdateAddress_Output_pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class OMRBranchClub extends BaseClass {
	String logtoken;
	String addressId;
	@Test(priority=1)
	public void login() throws Exception {
		addHeader("Content-Type", "application/json");
		String user = getPropertyFileValue("username");
		String pass = getPropertyFileValue("password");
		basicAuth(user, pass);
		Response response = requestType("POST", Endpoints.LOGIN);
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "verify status code");
		Login_Output_pojo login_Output_pojo = response.as(Login_Output_pojo.class);
		String first_name = login_Output_pojo.getData().getFirst_name();
		logtoken = login_Output_pojo.getData().getLogtoken();
		System.out.println(first_name);
		Assert.assertEquals(first_name, "suresh", "verify first_name");
	}

	@Test(priority=2)
	public void addAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " +logtoken);

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);
		addHeaders(headers);

		AddAddress_Input_pojo addAddress_Input_pojo = new AddAddress_Input_pojo("Suresh", "Kumar", "9876543456",
				"cthfhgc", 13, 32, 22, "600097", "utuft", "tutfug");
		addBody(addAddress_Input_pojo);
		Response response = requestType("POST", Endpoints.ADDADDRESS);
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "verify status code");
		AddAddress_Output_pojo addAddress_Output_pojo = response.as(AddAddress_Output_pojo.class);
		String message = addAddress_Output_pojo.getMessage();
		System.out.println(message);
		int id = addAddress_Output_pojo.getAddress_id();
		 addressId = String.valueOf(id);
		 System.out.println(addressId);
		Assert.assertEquals(message,"Address added successfully","verrify Address added successfully");
		
	}
	
	@Test(priority=3)
	public void updateAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " +logtoken);

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);
		addHeaders(headers);
		
		UpdateAddress_Input_pojo updateAddress_Input_pojo=new UpdateAddress_Input_pojo( addressId , "vinith", "Kumar", "9876543456",
				"cthfhgc", 13, 32, 22, "600097", "utuft", "tutfug");
		addBody(updateAddress_Input_pojo);
		Response response = requestType("PUT",Endpoints.UPDATEADDRESS );
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,200,"Verify statusCode");
		UpdateAddress_Output_pojo updateAddress_Output_pojo = response.as(UpdateAddress_Output_pojo.class);
		String message = updateAddress_Output_pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message,"Address updated successfully","Verify Address updated successfully");
	}
	
	@Test(priority=4)
	public void getAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " +logtoken);

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);
		addHeaders(headers);
		Response response = requestType("GET", Endpoints.GETADDRESS);
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200,"Verify statusCode");
		GetAddress_Output_pojo getAddress_Output_pojo = response.as(GetAddress_Output_pojo.class);
		String message = getAddress_Output_pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message,"OK","verify");
	}
	@Test(priority=5)
	public void deleteaddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " +logtoken);

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);
		addHeaders(headers);
		
		DeleteAddress_Input_pojo deleteAddress_Input_pojo=new DeleteAddress_Input_pojo(addressId);
		addBody(deleteAddress_Input_pojo);
		Response response = requestType("DELETE", Endpoints.DELETEADDRESS);
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200,"verify");
		DeleteAddress_Output_pojo deleteAddress_Output_pojo = response.as(DeleteAddress_Output_pojo.class);
		String message = deleteAddress_Output_pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message,"Address deleted successfully","verify");
		
	}
	@Test(priority=6)
	public void chageProfilePic() throws Exception {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "multipart/form-data");
		Header h2 = new Header("Authorization", "Bearer " +logtoken);

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);
		addHeaders(headers);
		
		multipart(getPropertyFileValue("path"));
		
		Response response = requestType("POST", Endpoints.CHANGEPROFILEPIC);
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode,200,"verify status code");
		ChangeProfilePic_Output_pojo changeProfilePic_Output_pojo = response.as(ChangeProfilePic_Output_pojo.class);
		String message = changeProfilePic_Output_pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message,"Profile updated Successfully","verify Profile updated Successfully");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
