package com.oivan.cashman.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.oivan.cashman.model.ExpenseItem;
import com.oivan.cashman.util.HibernateUtil;

public class HibernateTest {
	
	private Session session;
	private Transaction tx;
	private ExpenseItem expenseItem;
	
	@Before
	public void setUp() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	@Test
	public void testDataBase() {
		expenseItem = (ExpenseItem)session.get(ExpenseItem.class, 1);
		System.out.println("Name of item: " + expenseItem.getItemName());
		assertEquals(expenseItem.getItemName(), "food");
	}
	
	@Test
	public void testQueryToDataBase() {
		List<?> itemList = session.createQuery("from ExpenseItem").list();
		for (int i=0; i<itemList.size(); i++) {
			expenseItem = (ExpenseItem)itemList.get(i);
			System.out.println("Row " + (i + 1) + "> " + expenseItem.getItemName()
					+ " (" + expenseItem.getCostItemID() + ")");
		}
		assertNotNull(itemList);
	}
	
	@After
	public void tearDown() {
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
}