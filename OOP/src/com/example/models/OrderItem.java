package com.example.models;

public class OrderItem {
	private String productName;
	private int quantity;
	private double price;

	public OrderItem(String productName, int quantity) {
		this.quantity = quantity;
		this.productName = productName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}
}
