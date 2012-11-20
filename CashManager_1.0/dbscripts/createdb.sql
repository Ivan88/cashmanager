-- Drop tables if they exist
DROP TABLE IF EXISTS Users CASCADE;
DROP TABLE IF EXISTS ExpensesHistory CASCADE;
DROP TABLE IF EXISTS ExpenseItem CASCADE;
DROP TABLE IF EXISTS DayReport CASCADE;
DROP TABLE IF EXISTS MonthReport CASCADE;
DROP TABLE IF EXISTS YearReport CASCADE;
DROP TABLE IF EXISTS MonthSchedule CASCADE;

-- Create tables
CREATE TABLE Users (
	userID INTEGER PRIMARY KEY NOT NULL,
	name VARCHAR(100),
	password VARCHAR(10),
	balance FLOAT,
	email VARCHAR(255)
);

CREATE TABLE ExpenseItem (
	expenseItemID INTEGER PRIMARY KEY NOT NULL,
	itemName VARCHAR(100)
);

CREATE TABLE ExpensesHistory (
	expensesHistoryID INTEGER PRIMARY KEY NOT NULL,
	userID INTEGER REFERENCES Users(userID),
	expenseItemID INTEGER REFERENCES ExpenseItem(expenseItemID),
	amount FLOAT,
	date DATE
);

CREATE TABLE DayReport (
	dayReportID INTEGER PRIMARY KEY NOT NULL,
	userID INTEGER REFERENCES Users(userID),
	expensesHistoryID INTEGER REFERENCES ExpensesHistory(expensesHistoryID)
);

CREATE TABLE MonthReport (
	monthReportID INTEGER PRIMARY KEY NOT NULL,
	userID INTEGER REFERENCES Users(userID),
	dayReportID INTEGER REFERENCES DayReport(dayReportID)
);

CREATE TABLE YearReport (
	yearReportID INTEGER PRIMARY KEY NOT NULL,
	userID INTEGER REFERENCES Users(userID),
	monthReportID INTEGER  REFERENCES MonthReport(monthReportID)
);

CREATE TABLE MonthSchedule (
	monthScheduleID INTEGER PRIMARY KEY NOT NULL,
	userID INTEGER REFERENCES Users(userID),
	month VARCHAR(20),
	expenseItemID INTEGER REFERENCES ExpenseItem(expenseItemID),
	amount FLOAT
);