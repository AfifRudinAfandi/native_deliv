package com.build.delivery.pojoauth;

import com.google.gson.annotations.SerializedName;

public class AuthResponse{

	@SerializedName("data")
	private String data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setData(String data){
		this.data = data;
	}

	public String getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"AuthResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}