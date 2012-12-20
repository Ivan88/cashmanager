package com.oivan.cashman.model.reports;

public class MonthReport {
	
	private int monthReportId;
	private int userId;
	private int dayReportId;
	
	public int getMonthReportId() {
		return monthReportId;
	}
	public void setMonthReportId(int monthReportId) {
		this.monthReportId = monthReportId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDayReportId() {
		return dayReportId;
	}
	public void setDayReportId(int dayReportId) {
		this.dayReportId = dayReportId;
	}
}
