package com.kodewala.amazon.request;

public class OrderRequest {

	private String itemName;
	private String price;
	private String qty;

	public String getItemName() {
		return itemName;
	}

	public String getPrice() {
		return price;
	}

	public String getQty() {
		return qty;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

}
