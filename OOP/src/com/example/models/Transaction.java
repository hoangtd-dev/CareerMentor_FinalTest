package com.example.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
	private double amount;
	private String type;
	private LocalDateTime date;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public Transaction(double amount, String type) {
		this.amount = amount;
		this.type = type;
		date = LocalDateTime.now();
	}

	public double getAmount() {
		return amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "amount: " + amount + " type: " + type + " date: " + date.format(formatter);
	}
}
