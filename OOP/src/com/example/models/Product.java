package com.example.models;

public class Product {
	private String name;
	private double price;
	private int stock;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		stock = 0;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public void update(int stock) {
		this.stock += stock;
	}

	@Override
	public String toString() {
		return "name: " + name + " - stock:" + stock + " - price: " + price;
	}
}
