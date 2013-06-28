package com.oivan.monman.model;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.oivan.monman.util.HibernateUtil;

/**
 * Manages database operations for ExpensesHistory table.
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
					"from ExpensesHistoryItem" + " where userId = ? " +
					"and date >= ?"
					).setInteger(0, userId).setDate(1, fromPeriodDate).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return expensesHistoryItemsList;
	}

	/**
     * Returns expenses history item database record with matching 
     * expenseshistoryid
     */
	public ExpensesHistoryItem getExpensesHistoryItem(int expensesHistoryItemId) {
		ExpensesHistoryItem expensesHistoryItem = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			expensesHistoryItem = (ExpensesHistoryItem) session.createQuery(
					"from ExpensesHistoryItem" + " where expenseshistoryid = ?"
					).setParameter(0, expensesHistoryItemId).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return expensesHistoryItem;
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
	
	/**
	 * Delete Expenses history item from db
	 * @param expenseHistoryItemId - item id that should be removed
	 */
	public void deleteExpensesHistoryItem(int expenseHistoryItemId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.delete(session.load(ExpensesHistoryItem.class, new Integer(
					expenseHistoryItemId)));
			session.flush();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}
}
