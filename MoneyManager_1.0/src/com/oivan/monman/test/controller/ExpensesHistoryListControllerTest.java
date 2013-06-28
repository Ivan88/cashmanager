package com.oivan.monman.test.controller;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.oivan.monman.controller.ExpensesHistoryListController;
import com.oivan.monman.model.ExpensesHistoryItem;
import com.oivan.monman.model.ExpensesHistoryItemManager;
import com.oivan.monman.model.User;
import com.oivan.monman.util.ApplicationSecurityManager;

public class ExpensesHistoryListControllerTest {

	private MockHttpServletRequest mockHttpServletRequest = null;
	private ExpensesHistoryListController expensesHistoryListController = null;
	private ExpensesHistoryItemManager expensesHistoryItemManager = new ExpensesHistoryItemManager();
	private ApplicationSecurityManager applicationSecurityManager = new ApplicationSecurityManager();
	private final int USER_ID = 1;
	private static int historyItemId1 = 0;
	private static int historyItemId2 = 0;
	
	@Test
	public void testShowForm() throws Exception {
		mockHttpServletRequest = new MockHttpServletRequest("GET", 
				"expenseshistorylist.htm");
		User user = new User();
		user.setUserId(USER_ID);
		applicationSecurityManager.setUser(mockHttpServletRequest, user);
		
		expensesHistoryListController = new ExpensesHistoryListController();
		expensesHistoryListController.setExpensesHistoryItemManager(expensesHistoryItemManager);
		expensesHistoryListController.setApplicationSecurityManager(applicationSecurityManager);
		
		ModelAndView modelAndView = expensesHistoryListController.handleRequest(
				mockHttpServletRequest, null);
		
		assertNotNull(modelAndView);
		assertNotNull(modelAndView.getModel());
		
		List<ExpensesHistoryItem> expensesHistory = (List<ExpensesHistoryItem>) modelAndView.getModel().get(
				ExpensesHistoryListController.MAP_KEY);
		assertNotNull(expensesHistory);
		
		
		for (ExpensesHistoryItem item : expensesHistory) {
			assertEquals(USER_ID, item.getUserId());
			System.out.println(item.getExpensesHistoryItemId() + " passed!");
		}
	}
	
	@Before
	public void setUp() {
		ExpensesHistoryItem expensesHistoryItem = new ExpensesHistoryItem();
		expensesHistoryItem.setAmount(0.1);
		expensesHistoryItem.setDate(new Date());
		expensesHistoryItem.setExpenseItemId(1);
		expensesHistoryItem.setUserId(USER_ID);
		
		expensesHistoryItemManager.saveExpensesHistoryItem(expensesHistoryItem);
		historyItemId1 = expensesHistoryItem.getExpensesHistoryItemId();
		
		expensesHistoryItem = new ExpensesHistoryItem();
		expensesHistoryItem.setAmount(1.1);
		expensesHistoryItem.setDate(new Date());
		expensesHistoryItem.setExpenseItemId(1);
		expensesHistoryItem.setUserId(USER_ID);
		
		expensesHistoryItemManager.saveExpensesHistoryItem(expensesHistoryItem);
		historyItemId2 = expensesHistoryItem.getExpensesHistoryItemId();
	}
	
	/**
	 * Delete test ExpenseHistoryItem objects from db
	 */
	public void tearDown() {
		expensesHistoryItemManager.deleteExpensesHistoryItem(historyItemId1);
		expensesHistoryItemManager.deleteExpensesHistoryItem(historyItemId2);
	}
}
