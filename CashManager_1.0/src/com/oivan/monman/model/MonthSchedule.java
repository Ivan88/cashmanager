package com.oivan.monman.model;

public class MonthSchedule {

	private int monthScheduleId;
	private String monthName;
	private int userId;
	private int expenseItemId;
	private double amount;
	
	public int getMonthScheduleId() {
		return monthScheduleId;
	}
	public void setMonthScheduleId(int monthScheduleId) {
		this.monthScheduleId = monthScheduleId;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
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
	
	
}