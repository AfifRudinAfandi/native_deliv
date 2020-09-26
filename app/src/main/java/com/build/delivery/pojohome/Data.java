package com.build.delivery.pojohome;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data{

	@SerializedName("menu_best")
	private List<MenuBestItem> menuBest;

	@SerializedName("menu_top")
	private List<MenuTopItem> menuTop;

	public void setMenuBest(List<MenuBestItem> menuBest){
		this.menuBest = menuBest;
	}

	public List<MenuBestItem> getMenuBest(){
		return menuBest;
	}

	public void setMenuTop(List<MenuTopItem> menuTop){
		this.menuTop = menuTop;
	}

	public List<MenuTopItem> getMenuTop(){
		return menuTop;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"menu_best = '" + menuBest + '\'' + 
			",menu_top = '" + menuTop + '\'' + 
			"}";
		}
}