package com.oivan.monman.model;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.oivan.monman.util.HibernateUtil;

/**
 * Manages database operations for ExpensesHistoryItem table.
 * @author Ivan
 */
public class ExpensesHistoryItemManager {
	
	/**
     * Returns list of all expenses history database records with matching 
     * userId.
     */
	public List getExpensesHistoryItemsList(int userId, Date fromPeriodDate) {
		List expensesHistoryItemsList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			expensesHistoryItemsList = session.createQuery(
					"from ExpensesHistoryItem" + " where userId = ?" +
					"and date >= ?"
					).setInteger(0, userId).setDate(1, fromPeriodDate).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return expensesHistoryItemsList;
	}

//	public List getExpensesHistoryList() {
//		List expensesHistoryList = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		try {
//			expensesHistoryList = session.createQuery(
//					"from ExpensesHistoryItem"
//					).list();
//			session.getTransaction().commit();
//		} catch (HibernateException e) {
//			session.getTransaction().rollback();
//			throw e;
//		}
//		return expensesHistoryList;
//	}
	
	/**
	 * Saves Expenses history item
	 * @param expensesHistoryItem - object that should be saved to db 
	 */
	public void saveExpensesHistoryItem(ExpensesHistoryItem expensesHistoryItem) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(expensesHistoryItem);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}
}
