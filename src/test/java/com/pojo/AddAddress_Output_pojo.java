package com.pojo;

/**
 * 
 * @author Suresh Kumar G
 * @Description To contains add address output pojo
 * @CreationDate 27/06/2022
 */
public class AddAddress_Output_pojo {

	private int status;
	private String message;
	private int address_id;

	/**
	 * 
	 * @return string
	 * @Description add address response body Getters and Setters
	 * @CreationDate 27/06/2022
	 */
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

}
