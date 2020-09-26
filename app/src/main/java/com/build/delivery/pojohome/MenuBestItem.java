package com.build.delivery.pojohome;

import com.google.gson.annotations.SerializedName;

public class MenuBestItem{

	@SerializedName("image")
	private String image;

	@SerializedName("description")
	private String description;

	@SerializedName("discount")
	private Object discount;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("merchant_id")
	private String merchantId;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("time_process")
	private String timeProcess;

	@SerializedName("free_deliv")
	private boolean freeDeliv;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("price")
	private String price;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("tag")
	private String tag;

	@SerializedName("category")
	private String category;

	@SerializedName("status")
	private boolean status;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setDiscount(Object discount){
		this.discount = discount;
	}

	public Object getDiscount(){
		return discount;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setMerchantId(String merchantId){
		this.merchantId = merchantId;
	}

	public String getMerchantId(){
		return merchantId;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setTimeProcess(String timeProcess){
		this.timeProcess = timeProcess;
	}

	public String getTimeProcess(){
		return timeProcess;
	}

	public void setFreeDeliv(boolean freeDeliv){
		this.freeDeliv = freeDeliv;
	}

	public boolean isFreeDeliv(){
		return freeDeliv;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTag(String tag){
		this.tag = tag;
	}

	public String getTag(){
		return tag;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"MenuBestItem{" + 
			"image = '" + image + '\'' + 
			",description = '" + description + '\'' + 
			",discount = '" + discount + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",merchant_id = '" + merchantId + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",time_process = '" + timeProcess + '\'' + 
			",free_deliv = '" + freeDeliv + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",price = '" + price + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",tag = '" + tag + '\'' + 
			",category = '" + category + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}