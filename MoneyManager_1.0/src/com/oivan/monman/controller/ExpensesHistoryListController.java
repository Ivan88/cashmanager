package com.oivan.monman.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.oivan.monman.model.ExpensesHistoryItemManager;
import com.oivan.monman.model.User;
import com.oivan.monman.util.ApplicationSecurityManager;
import com.oivan.monman.util.MonmanJmxBean;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class ExpensesHistoryListController implements Controller{

	private ExpensesHistoryItemManager expensesHistoryItemManager;
	private ApplicationSecurityManager applicationSecurityManager;
	private MonmanJmxBean monmanJmxBean;
	private String successView;
	public static final String MAP_KEY = "expenseshistory";
//	private 
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		User user = (User) applicationSecurityManager.getUser(request);
		List expensesHistoryItems = expensesHistoryItemManager.getExpensesHistoryItemsList(user.getUserId(), null);
		monmanJmxBean.setExpensesHistoryItemsFetched(monmanJmxBean.getExpensesHistoryItemsFetched() + expensesHistoryItems.size());
		return new ModelAndView(getSuccessView(), MAP_KEY, expensesHistoryItems);
	}

	public ExpensesHistoryItemManager getExpensesHistoryItemManager() {
		return expensesHistoryItemManager;
	}

	public void setExpensesHistoryItemManager(
			ExpensesHistoryItemManager expensesHistoryItemManager) {
		this.expensesHistoryItemManager = expensesHistoryItemManager;
	}

	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	public ApplicationSecurityManager getApplicationSecurityManager() {
		return applicationSecurityManager;
	}

	public void setApplicationSecurityManager(
			ApplicationSecurityManager applicationSecurityManager) {
		this.applicationSecurityManager = applicationSecurityManager;
	}

	public MonmanJmxBean getMonmanJmxBean() {
		return monmanJmxBean;
	}

	public void setMonmanJmxBean(MonmanJmxBean monmanJmxBean) {
		this.monmanJmxBean = monmanJmxBean;
	}

}