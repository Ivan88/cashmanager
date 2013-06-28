package com.oivan.monman.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.oivan.monman.model.ExpensesHistoryItem;
import com.oivan.monman.model.ExpensesHistoryItemManager;
import com.oivan.monman.model.User;
import com.oivan.monman.util.ApplicationSecurityManager;

public class EnterExpensesController extends SimpleFormController{
	
	private ExpensesHistoryItemManager expensesHistoryItemManager = null;
	private ApplicationSecurityManager applicationSecurityManager = null;
	public static final String TID = "tid";
	
	protected Object formBackingObject(HttpServletRequest request) {
		if (request.getParameter(TID) != null
				&& request.getParameter(TID).trim().length() > 0)
			return expensesHistoryItemManager.getExpensesHistoryItem(Integer.parseInt(request.getParameter(TID)));
		
		ExpensesHistoryItem expensesHistoryItem = new ExpensesHistoryItem();
		User user = (User) applicationSecurityManager.getUser(request);
		expensesHistoryItem.setUserId(user.getUserId());
		return expensesHistoryItem;
	}
	
//	protected void initBinder(HttpServletRequest request,
//			ServletRequestDataBinder binder) {
//		
//		binder.registerCustomEditor(int.class, null);
//	}
	
	public ExpensesHistoryItemManager getExpensesHistoryItemManager() {
		return expensesHistoryItemManager;
	}
	public void setExpensesHistoryItemManager(
			ExpensesHistoryItemManager expensesHistoryItemManager) {
		this.expensesHistoryItemManager = expensesHistoryItemManager;
	}
	public ApplicationSecurityManager getApplicationSecurityManager() {
		return applicationSecurityManager;
	}
	public void setApplicationSecurityManager(
			ApplicationSecurityManager applicationSecurityManager) {
		this.applicationSecurityManager = applicationSecurityManager;
	}
}
