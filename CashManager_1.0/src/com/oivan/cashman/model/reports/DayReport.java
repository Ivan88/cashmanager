package com.oivan.cashman.model.reports;

public class DayReport {
	
	private int dayReportId;
	private int userId;
	private int expensesHistoryId;
	
	public int getDayReportId() {
		return dayReportId;
	}
	public void setDayReportId(int dayReportId) {
		this.dayReportId = dayReportId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getExpensesHistoryId() {
		return expensesHistoryId;
	}
	public void setExpensesHistoryId(int cashExpensesHistoryId) {
		this.expensesHistoryId = cashExpensesHistoryId;
	}
}
