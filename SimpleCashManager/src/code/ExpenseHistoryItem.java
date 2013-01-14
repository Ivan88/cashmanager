package code;

public class ExpenseHistoryItem {
	
	private int expenseHistoryItemId;
	private int expenseItemId;
	private int cashAmount;
	private String description;
	
	public int getExpenseHistoryItemId() {
		return expenseHistoryItemId;
	}
	public void setExpenseHistoryItemId(int expenseHistoryItemId) {
		this.expenseHistoryItemId = expenseHistoryItemId;
	}
	public int getExpenseItemId() {
		return expenseItemId;
	}
	public void setExpenseItemId(int expenseItemId) {
		this.expenseItemId = expenseItemId;
	}
	public int getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(int cashAmount) {
		this.cashAmount = cashAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
