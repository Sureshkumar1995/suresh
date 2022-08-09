package com.pojo;

/**
 * 
 * @author Suresh Kumar G
 * @Description To contains change profile picture output pojo
 * @CreationDate 27/06/2022
 *
 */
public class ChangeProfilePic_Output_pojo {

	private int status;
	private String message;
	private DataChangePic data;
	private int cart_count;

	/**
	 * 
	 * @return string
	 * @Description Change profile picture response body Getters and Setters
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

	public DataChangePic getData() {
		return data;
	}

	public void setData(DataChangePic data) {
		this.data = data;
	}

	public int getCart_count() {
		return cart_count;
	}

	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}

}
