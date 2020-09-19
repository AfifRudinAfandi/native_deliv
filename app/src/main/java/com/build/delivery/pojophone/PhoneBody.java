package com.build.delivery.pojophone;

import com.google.gson.annotations.SerializedName;

public class PhoneBody{

	@SerializedName("phone")
	private String phone;

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	@Override
 	public String toString(){
		return 
			"PhoneBody{" + 
			"phone = '" + phone + '\'' + 
			"}";
		}
}