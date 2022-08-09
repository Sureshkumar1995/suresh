package com.pojo;

import java.util.ArrayList;

/**
 * 
 * @author Suresh Kumar G
 * @Description To contains get address output pojo
 * @CreationDate 27/06/2022
 *
 */
public class GetAddress_Output_pojo {
	private int status;
	private String message;
	private ArrayList<Datum> data;

	/**
	 * 
	 * @return String
	 * @Description Getters and setters
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

	public ArrayList<Datum> getData() {
		return data;
	}

	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}

}
