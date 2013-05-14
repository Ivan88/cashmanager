package com.oivan.cashman.test.hibernate;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.oivan.cashman.model.ExpensesHistoryItem;
import com.oivan.cashman.model.ExpenseItem;
import com.oivan.cashman.model.MonthSchedule;
import com.oivan.cashman.model.User;
import com.oivan.cashman.model.reports.DayReport;
import com.oivan.cashman.model.reports.MonthReport;
import com.oivan.cashman.model.reports.YearReport;
import com.oivan.cashman.util.HibernateUtil;

public class HibernateTest {
	
	private static Session session;
	private ExpenseItem expenseItem;
	private ExpensesHistoryItem expensesHistoryItem;
	private MonthSchedule monthSchedule;
	private User user;
	private DayReport dayReport;
	private MonthReport monthReport;
	private YearReport yearReport;
	
	@BeforeClass
	public static void setUp() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	@Test
	public void testExpenseItem() {
		expenseItem = (ExpenseItem)session.get(ExpenseItem.class, 1);
		assertEquals("food", expenseItem.getItemName());
		if (expenseItem != null)
			System.out.println("Name of expenseItem: " + expenseItem.getItemName());
	}
	
	@Test
	public void testExpenseHistoryItem() {
		expensesHistoryItem = (ExpensesHistoryItem)session.get(ExpensesHistoryItem.class, 1);
		assertNotNull(expensesHistoryItem);
		if (expensesHistoryItem != null)
			System.out.println("Cash amount of expensesHistoryItem: " + expensesHistoryItem.getAmount());
	}
	
	@Test
	public void testMonthSchedule() {
		monthSchedule = (MonthSchedule)session.get(MonthSchedule.class, 1);
		assertNotNull("Month name is null", monthSchedule);
		if (monthSchedule != null)
			System.out.println("Name of month: " + monthSchedule.getMonthName());
	}
	
	@Test
	public void testUser() {
		user = (User)session.get(User.class, 1);
		assertNotNull("User name is null", user);
		if (user != null)
			System.out.println("Name of user: " + user.getName());
	}
	
	@Test
	public void testDayReport() {
		dayReport = (DayReport)session.get(DayReport.class, 1);
		assertNotNull("Dayreport is null", dayReport);
		if (dayReport != null)
			System.out.println("Dayreport: " + dayReport.getDayReportId());
	}
	
	@Test
	public void testMonthReport() {
		monthReport = (MonthReport)session.get(MonthReport.class, 1);
		assertNotNull("Monthreport is null", monthReport);
		if (monthReport != null)
			System.out.println("Monthreport: " + monthReport.getMonthReportId());
	}
	
	@Test
	public void testYearReport() {
		yearReport = (YearReport)session.get(YearReport.class, 1);
		assertNotNull("Yearreport is null", yearReport);
		if (yearReport != null)
			System.out.println("Yearreport: " + yearReport.getYearReportId());
	}
	
	@AfterClass
	public static void tearDown() {
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
}