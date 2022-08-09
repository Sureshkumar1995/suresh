package com.pojo;

/**
 * 
 * @author Suresh Kumar G
 * @Description To contains delete input pojo
 * @CreationDate 27/06/2022
 */
public class DeleteAddress_Input_pojo {

	private String address_id;

	/**
	 * 
	 * @param address_id
	 * @Description Delete input pojo constructor
	 * @CreationDate 27/06/2022
	 */
	public DeleteAddress_Input_pojo(String address_id) {
		super();
		this.address_id = address_id;
	}

	/**
	 * 
	 * @return string
	 * @Description Getters and setters
	 * @CreationDate 27/06/2022
	 */
	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

}
