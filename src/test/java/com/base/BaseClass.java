package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author Suresh Kumar G
 * @Description To contains reusable method
 * @CreationDate 27/06/2022
 */
public class BaseClass {

	public static RequestSpecification reqSpec;
	public static Response response;

	/**
	 * 
	 * @param key
	 * @param value
	 * @Description Used to add header
	 * @CreationDate 27/06/2022
	 */
	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @Description Used to add query parameter
	 * @CreationDate 27/06/2022
	 */
	public void queryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @Description Used to add path parameter
	 * @CreationDate 27/06/2022
	 */
	public void pathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	/**
	 * 
	 * @param reqBody
	 * @Description Used to add request body for String
	 * @CreationDate 27/06/2022
	 */
	public void addBody(String reqBody) {
		reqSpec = reqSpec.body(reqBody);
	}

	/**
	 * 
	 * @param path
	 * @Description Used to add multipart method
	 * @CreationDate 27/06/2022
	 */
	public static void multipart(String path) {
		reqSpec = reqSpec.multiPart("profile_picture", new File(path));

	}

	/**
	 * 
	 * @param reqBody
	 * @Description Used to add body for Object
	 * @CreationDate 27/06/2022
	 */
	public void addBody(Object reqBody) {
		reqSpec = reqSpec.body(reqBody);
	}

	/**
	 * 
	 * @param reqType
	 * @param endpoint
	 * @return Response
	 * @Description Used to pass request type
	 * @CreationDate 27/06/2022
	 */
	public Response requestType(String reqType, String endpoint) {
		switch (reqType) {
		case "GET":
			response = reqSpec.log().all().get(endpoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endpoint);
			break;
		case "PUT":
			response = reqSpec.log().all().put(endpoint);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endpoint);
			break;

		default:
			break;
		}
		return response;
	}

	/**
	 * 
	 * @param response
	 * @return Response
	 * @Description Used to get status code
	 * @CreationDate 27/06/2022
	 */
	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	/**
	 * 
	 * @param response
	 * @return ResponseBody
	 * @Description Used to get response body
	 * @CreationDate 27/06/2022
	 */
	public ResponseBody getBody(Response response) {
		ResponseBody body = response.getBody();
		return body;
	}

	/**
	 * 
	 * @param response
	 * @return String
	 * @Description Used to get response body as string
	 * @CreationDate 27/06/2022
	 */
	public String getResBodyAsString(Response response) {
		String asString = getBody(response).asString();
		return asString;
	}

	/**
	 * 
	 * @param response
	 * @return String
	 * @Description Used to get response body as pretty string
	 * @CreationDate 27/06/2022
	 */
	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = getBody(response).asPrettyString();
		return asPrettyString;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @Description Used to perform basic authentication
	 * @CreationDate 27/06/2022
	 */
	public void basicAuth(String username, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(username, password);

	}

	/**
	 * 
	 * @param key
	 * @return String
	 * @throws Exception
	 * @Description Used to get value from property file
	 * @CreationDate 27/06/2022
	 */
	public String getPropertyFileValue(String key) throws Exception {
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
		Properties properties = new Properties();
		properties.load(stream);
		Object object = properties.get(key);
		String string = (String) object;
		return string;

	}

	/**
	 * 
	 * @param headers
	 * @Description Used to add multiple headers
	 * @CreationDate 27/06/2022
	 */
	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);

	}

}
