package com.example;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.models.Order;
import com.example.models.OrderItem;
import com.example.models.Product;
import com.example.models.Transaction;

public class Main {
	private static final HashMap<String, Product> products = new HashMap<>();
	private static final ArrayList<Transaction> transactions = new ArrayList<>();
	private static final ArrayList<Order> orders = new ArrayList<>();
	private static int count = 0;

	public static void main(String[] args) {
		System.out.println(addProduct("iphone", 10));
		System.out.println(addProduct("iphone", 20));
		System.out.println(addProduct("ipad", 0));

		System.out.println(updateProduct("iphone", -1));
		System.out.println(updateProduct("iphone", 0));
		System.out.println(updateProduct("iphone", 3));
		System.out.println(updateProduct("iphone", -1));
		System.out.println(updateProduct("new iphone", 3));

		System.out.println(addProduct("ipad", 40));
		System.out.println(addProduct("tv", 100));
		System.out.println(addProduct("macbook", 200));
		System.out.println(updateProduct("ipad", 3));
		System.out.println(updateProduct("tv", 3));
		System.out.println(updateProduct("macbook", 3));

		ArrayList<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem("ipad", 2));
		items.add(new OrderItem("iphone", 2));
		items.add(new OrderItem("macbook", 2));
		System.out.println("buy: " + buy(items));

		ArrayList<OrderItem> items_2 = new ArrayList<>();
		items_2.add(new OrderItem("ipad", 1));
		items_2.add(new OrderItem("macbook", 1));
		System.out.println("buy: " + buy(items_2));

		System.out.println("--------ORDER----------");

		for (Order order : orders) {
			System.out.println(order.toString());
		}

		System.out.println("--------PRODUCT----------");
		for (Product product : products.values()) {
			System.out.println(product);
		}

		System.out.println("--------TRANSACTION----------");
		for (Transaction transaction : transactions) {
			System.out.println(transaction);
		}
	}

	public static boolean addProduct(String name, double price) {
		if (products.containsKey(name) || price <= 0)
			return false;

		products.put(name, new Product(name, price));
		return true;
	}

	public static boolean updateProduct(String productName, int stock) {
		if (!products.containsKey(productName) || products.get(productName).getStock() + stock < 0)
			return false;

		Product product = products.get(productName);
		product.update(stock);
		transactions.add(new Transaction(stock, "STOCK_IN"));

		return true;
	}

	public static boolean buy(ArrayList<OrderItem> items) {
		for (OrderItem item : items) {
			System.out.println(products.get(item.getProductName()).getStock() - item.getQuantity());
			if (!products.containsKey(item.getProductName())
					|| products.get(item.getProductName()).getStock() - item.getQuantity() < 0
					|| item.getQuantity() <= 0)
				return false;
		}
		Order order = new Order(++count, items);

		for (OrderItem item : items) {
			Product product = products.get(item.getProductName());
			product.update(-item.getQuantity());
			item.setPrice(product.getPrice());
			transactions.add(new Transaction(-item.getQuantity(), order.getCode()));
		}

		orders.add(order);
		order.updateTotal();

		return true;
	}
}
