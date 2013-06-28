package com.oivan.monman.util;

public class MonmanJmxBean {
	
	private static int signInCount;
	private static int expensesHistoryItemsFetched;
	
	public static int getSignInCount() {
		return signInCount;
	}
	public static void setSignInCount(int signInCount) {
		MonmanJmxBean.signInCount = signInCount;
	}
	public static int getExpensesHistoryItemsFetched() {
		return expensesHistoryItemsFetched;
	}
	public static void setExpensesHistoryItemsFetched(
			int expensesHistoryItemsFetched) {
		MonmanJmxBean.expensesHistoryItemsFetched = expensesHistoryItemsFetched;
	}
}
