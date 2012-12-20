package com.oivan.cashman.model;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.oivan.cashman.util.HibernateUtil;

/**
 * Manages database operations for ExpensesHistory table.
 * @author Ivan
 */
public class ExpensesHistoryManager {
	
//	private List<ExpensesHistory> expensesHistoryList;

	/**
     * Returns list of all expenses history database records with matching 
     * userId.
     */
	public List getExpensesHistoryList(int userId, Date fromPeriodDate) {
		List expensesHistoryList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			expensesHistoryList = session.createQuery(
					"from ExpensesHistory" + " where userId = ?" +
					"and date >= ?"
					).setInteger(0, userId).setDate(1, fromPeriodDate).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return expensesHistoryList;
	}

	public List getExpensesHistoryList() {
		List expensesHistoryList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			expensesHistoryList = session.createQuery(
					"from ExpensesHistory"
					).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return expensesHistoryList;
	}
}
