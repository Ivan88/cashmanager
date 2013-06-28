package com.oivan.monman.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.oivan.monman.model.ExpensesHistoryItem;
import com.oivan.monman.model.ExpensesHistoryItemManager;

public class ExpensesHistoryItemManagerTest {
	
	private ExpensesHistoryItemManager expensesHistoryItemManager = new ExpensesHistoryItemManager();
	private Date date = new Date();
	
	@Test
	public void testGetExpensesHistoryItemsList() {
		List expensesHistoryItemsList = expensesHistoryItemManager.getExpensesHistoryItemsList(1, date);
		assertNotNull(expensesHistoryItemsList);
		assertTrue(expensesHistoryItemsList.size() > 0);
		
		ExpensesHistoryItem expensesHistoryItem;
		for (int i = 0; i < expensesHistoryItemsList.size(); i++) {
			expensesHistoryItem = (ExpensesHistoryItem) expensesHistoryItemsList.get(i);
			assertEquals(1, expensesHistoryItem.getUserId());
		}
	}
	
	@Test
	public void testGetExpensesHistoryItem() {
		ExpensesHistoryItem expensesHistoryItem = (ExpensesHistoryItem) expensesHistoryItemManager.getExpensesHistoryItem(1);
		assertNotNull(expensesHistoryItem);
	}
	
	@Test
	public void testSaveExpensesHistoryItem() {
		ExpensesHistoryItem expensesHistoryItem = new ExpensesHistoryItem();
		expensesHistoryItem.setAmount(999);
		expensesHistoryItem.setDate(date);
		expensesHistoryItem.setExpenseItemId(1);
		expensesHistoryItem.setUserId(2);
		
		expensesHistoryItemManager.saveExpensesHistoryItem(expensesHistoryItem);
		
		ExpensesHistoryItem expensesHistoryItemSaved = (ExpensesHistoryItem) expensesHistoryItemManager.getExpensesHistoryItemsList(2, date).get(0);
		
		assertEquals(expensesHistoryItemSaved.getAmount(), expensesHistoryItem.getAmount(), 0.0);
//		assertEquals(expensesHistoryItemSaved.getDate(), expensesHistoryItem.getDate());
		assertEquals(expensesHistoryItemSaved.getExpenseItemId(), expensesHistoryItem.getExpenseItemId());
		assertEquals(expensesHistoryItemSaved.getExpensesHistoryItemId(), expensesHistoryItem.getExpensesHistoryItemId());
		assertEquals(expensesHistoryItemSaved.getUserId(), expensesHistoryItem.getUserId());
	}
	
	@Test
	public void testDeleteExpensesHistoryItem() {
		ExpensesHistoryItem expensesHistoryItem = new ExpensesHistoryItem();
		expensesHistoryItem.setAmount(999);
		expensesHistoryItem.setDate(date);
		expensesHistoryItem.setExpenseItemId(1);
		expensesHistoryItem.setUserId(2);
		
		expensesHistoryItemManager.saveExpensesHistoryItem(expensesHistoryItem);
		
		ExpensesHistoryItem expensesHistoryItemSaved = (ExpensesHistoryItem) expensesHistoryItemManager.getExpensesHistoryItemsList(2, date).get(0);
		
		expensesHistoryItemManager.deleteExpensesHistoryItem(expensesHistoryItemSaved.getExpensesHistoryItemId());
		
		assertNull(expensesHistoryItemManager.getExpensesHistoryItem(
				expensesHistoryItemSaved.getExpensesHistoryItemId()));
	}
}