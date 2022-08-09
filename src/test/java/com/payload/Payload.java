package com.payload;

import com.pojo.AddAddress_Input_pojo;
import com.pojo.DeleteAddress_Input_pojo;
import com.pojo.UpdateAddress_Input_pojo;

/**
 * 
 * @author Suresh Kumar G
 * @Description To contains all payload for end points
 * @CreationDate 27/06/2022
 *
 */
public class Payload {
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param addressType
	 * @return AddAddress_Input_pojo
	 * @Description Used to add payload for add address end points
	 * @CreationDate 27/06/2022
	 */
	public static AddAddress_Input_pojo createAddress(String firstname, String lastname, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String addressType) {

		AddAddress_Input_pojo addAddress_Input_pojo = new AddAddress_Input_pojo(firstname, lastname, mobile, apartment,
				state, city, country, zipcode, address, addressType);
		return addAddress_Input_pojo;

	}

	/**
	 * 
	 * @param addressId
	 * @param firstname
	 * @param lastname
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param addressType
	 * @return UpdateAddress_Input_pojo
	 * @Description Used to add payload for update address end points
	 * @CreationDate 27/06/2022
	 */
	public static UpdateAddress_Input_pojo updateAddress(String addressId, String firstname, String lastname,
			String mobile, String apartment, int state, int city, int country, String zipcode, String address,
			String addressType) {
		UpdateAddress_Input_pojo updateAddress_Input_pojo = new UpdateAddress_Input_pojo(addressId, firstname, lastname,
				mobile, apartment, state, city, country, zipcode, address, addressType);
		return updateAddress_Input_pojo;

	}

	/**
	 * 
	 * @param address_id
	 * @return DeleteAddress_Input_pojo
	 * @Description Used to add payload for delete address end points
	 * @CreationDate 27/06/2022
	 */
	public static DeleteAddress_Input_pojo deleteAddress(String address_id) {
		DeleteAddress_Input_pojo deleteAddress_Input_pojo = new DeleteAddress_Input_pojo(address_id);
		return deleteAddress_Input_pojo;

	}

}
