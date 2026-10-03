package com.example.models;

import java.util.ArrayList;

public class Order {
	private String code;
	private ArrayList<OrderItem> items;
	private double total;

	public Order(int code, ArrayList<OrderItem> items) {
		this.code = String.format("ORD-%03d", code);
		this.items = items;
	}

	public void updateTotal() {
		for (OrderItem item : items) {
			total += item.getQuantity() * item.getPrice();
		}
	}

	public double getTotal() {
		return total;
	}

	public String getCode() {
		return code;
	}

	public ArrayList<OrderItem> getItems() {
		return items;
	}

	@Override
	public String toString() {
		String result = "";

		System.out.println(getCode() + ": total: " + getTotal());

		for (OrderItem item : items) {
			System.out
					.println(
							"name: " + item.getProductName() + " - price" + item.getPrice() + "- quantity: " + item.getQuantity());
		}

		return result;
	}
}
