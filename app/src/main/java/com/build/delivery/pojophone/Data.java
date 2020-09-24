package com.build.delivery.pojophone;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("phone")
	private String phone;

	@SerializedName("otp")
	private String otp;

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setOtp(String otp){
		this.otp = otp;
	}

	public String getOtp(){
		return otp;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"phone = '" + phone + '\'' + 
			",otp = '" + otp + '\'' + 
			"}";
		}
}