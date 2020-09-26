package com.build.delivery.pojomenudetail;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("menu")
	private Menu menu;

	public void setMenu(Menu menu){
		this.menu = menu;
	}

	public Menu getMenu(){
		return menu;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"menu = '" + menu + '\'' + 
			"}";
		}
}