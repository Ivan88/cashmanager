package com.oivan.cashman.model;

import java.util.Date;

public class ExpensesHistory {

	private int expensesHistoryId;
	private int userId;
	private int expenseItemId;
	private double amount;
	private Date date;
	
	public int getExpensesHistoryId() {
		return expensesHistoryId;
	}
	public void setExpensesHistoryId(int expensesHistoryId) {
		this.expensesHistoryId = expensesHistoryId;
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
