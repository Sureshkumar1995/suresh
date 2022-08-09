package com.pojo;

/**
 * 
 * @author Suresh Kumar G
 * @Description To contains all common variables
 * @CreationDate 27/06/2022
 *
 */
public class CommonVariables {

	private String logToken;
	private int ststusCode;
	private String addressId;

	/**
	 * 
	 * @return string
	 * @Description Common variables getters and setters
	 * @CreationDate 27/06/2022
	 */
	public int getStstusCode() {
		return ststusCode;
	}

	public void setStstusCode(int ststusCode) {
		this.ststusCode = ststusCode;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getLogToken() {
		return logToken;
	}

	public void setLogToken(String logToken) {
		this.logToken = logToken;
	}

}
