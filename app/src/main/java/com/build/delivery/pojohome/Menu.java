package com.build.delivery.pojohome;

import com.google.gson.annotations.SerializedName;

public class Menu{

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

	public String getImage(){
		return image;
	}

	public String getDescription(){
		return description;
	}

	public Object getDiscount(){
		return discount;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getMerchantId(){
		return merchantId;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public String getTimeProcess(){
		return timeProcess;
	}

	public boolean isFreeDeliv(){
		return freeDeliv;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getPrice(){
		return price;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getTag(){
		return tag;
	}

	public String getCategory(){
		return category;
	}

	public boolean isStatus(){
		return status;
	}
}