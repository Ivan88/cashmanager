package com.oivan.monman.model;

import java.util.Date;

public class ExpensesHistoryItem {

	private int expensesHistoryItemId;
	private int userId;
	private int expenseItemId;
	private double amount;
	private Date date;
	
	public int getExpensesHistoryItemId() {
		return expensesHistoryItemId;
	}
	public void setExpensesHistoryItemId(int expensesHistoryItemId) {
		this.expensesHistoryItemId = expensesHistoryItemId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getExpenseItemId() {
		return expenseItemId;
	}
	public void setExpenseItemId(int expenseItemId) {
		this.expenseItemId = expenseItemId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
