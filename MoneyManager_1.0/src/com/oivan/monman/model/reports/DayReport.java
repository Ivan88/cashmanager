package com.oivan.monman.model.reports;

public class DayReport {
	
	private int dayReportId;
	private int userId;
	private int expensesHistoryItemId;
	
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
		return expensesHistoryItemId;
	}
	public void setExpensesHistoryId(int expensesHistoryItemId) {
		this.expensesHistoryItemId = expensesHistoryItemId;
	}
}
