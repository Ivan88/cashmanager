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
	userID Serial PRIMARY KEY NOT NULL,
	name VARCHAR(100),
	password VARCHAR(10),
	balance FLOAT,
	email VARCHAR(255)
);

CREATE TABLE ExpenseItem (
	expenseItemID Serial PRIMARY KEY NOT NULL,
	itemName VARCHAR(100)
);

CREATE TABLE ExpensesHistory (
	expensesHistoryID Serial PRIMARY KEY NOT NULL,
	userID INTEGER REFERENCES Users(userID),
	expenseItemID INTEGER REFERENCES ExpenseItem(expenseItemID),
	amount FLOAT,
	date DATE
);

CREATE TABLE DayReport (
	dayReportID Serial PRIMARY KEY NOT NULL,
	userID INTEGER REFERENCES Users(userID),
	expensesHistoryID INTEGER REFERENCES ExpensesHistory(expensesHistoryID)
);

CREATE TABLE MonthReport (
	monthReportID Serial PRIMARY KEY NOT NULL,
	userID INTEGER REFERENCES Users(userID),
	dayReportID INTEGER REFERENCES DayReport(dayReportID)
);

CREATE TABLE YearReport (
	yearReportID Serial PRIMARY KEY NOT NULL,
	userID INTEGER REFERENCES Users(userID),
	monthReportID INTEGER  REFERENCES MonthReport(monthReportID)
);

CREATE TABLE MonthSchedule (
	monthScheduleID Serial PRIMARY KEY NOT NULL,
	userID INTEGER REFERENCES Users(userID),
	monthName VARCHAR(20),
	expenseItemID INTEGER REFERENCES ExpenseItem(expenseItemID),
	amount FLOAT
);

INSERT INTO Users (name, password, balance, email)
VALUES ('ivan', '514840', 1000000.0, 'omelivan@mail.ru');
INSERT INTO Users (name, password, balance, email)
VALUES ('user1', 'user1', 10.0, 'somemail1@mail.ru');
INSERT INTO Users (name, password, balance, email)
VALUES ('user2', 'user2', 20.0, 'somemail2@mail.ru');
INSERT INTO Users (name, password, balance, email)
VALUES ('user3', 'user3', 30.0, 'somemail3@mail.ru');

INSERT INTO ExpenseItem (itemName)
VALUES ('food');
INSERT INTO ExpenseItem (itemName)
VALUES ('dress');
INSERT INTO ExpenseItem (itemName)
VALUES ('church');
INSERT INTO ExpenseItem (itemName)
VALUES ('transport');
INSERT INTO ExpenseItem (itemName)
VALUES ('work');

INSERT INTO ExpensesHistory (userID, expenseItemID, amount,	date)
VALUES (1, 2, '55', '2013-01-02');
INSERT INTO ExpensesHistory (userID, expenseItemID, amount,	date)
VALUES (2, 5, '43', '2013-01-03');
INSERT INTO ExpensesHistory (userID, expenseItemID, amount,	date)
VALUES (3, 1, '12', '2013-07-02');
INSERT INTO ExpensesHistory (userID, expenseItemID, amount,	date)
VALUES (4, 4, '17', '2013-12-02');
INSERT INTO ExpensesHistory (userID, expenseItemID, amount,	date)
VALUES (1, 4, '7777', '2013-01-22');
INSERT INTO ExpensesHistory (userID, expenseItemID, amount,	date)
VALUES (2, 1, '190', '2013-01-12');
INSERT INTO ExpensesHistory (userID, expenseItemID, amount,	date)
VALUES (3, 3, '2000', '2013-01-02');
INSERT INTO ExpensesHistory (userID, expenseItemID, amount,	date)
VALUES (4, 3, '11', '2013-05-02');
INSERT INTO ExpensesHistory (userID, expenseItemID, amount,	date)
VALUES (1, 5, '655', '2013-09-02');

INSERT INTO DayReport (userID, expensesHistoryID)
VALUES (1, 1);
INSERT INTO DayReport (userID, expensesHistoryID)
VALUES (2, 2);
INSERT INTO DayReport (userID, expensesHistoryID)
VALUES (3, 3);
INSERT INTO DayReport (userID, expensesHistoryID)
VALUES (4, 4);

INSERT INTO MonthReport (userID, dayReportID)
VALUES (1, 1);
INSERT INTO MonthReport (userID, dayReportID)
VALUES (2, 2);
INSERT INTO MonthReport (userID, dayReportID)
VALUES (3, 3);
INSERT INTO MonthReport (userID, dayReportID)
VALUES (4, 4);

INSERT INTO YearReport (userID, monthReportID)
VALUES (1, 1);
INSERT INTO YearReport (userID, monthReportID)
VALUES (2, 2);
INSERT INTO YearReport (userID, monthReportID)
VALUES (3, 3);
INSERT INTO YearReport (userID, monthReportID)
VALUES (4, 4);

INSERT INTO MonthSchedule (userID, monthName, expenseItemID, amount)
VALUES (1, 'march', 1, 10.1);
INSERT INTO MonthSchedule (userID, monthName, expenseItemID, amount)
VALUES (2, 'february', 5, 700.0);
INSERT INTO MonthSchedule (userID, monthName, expenseItemID, amount)
VALUES (3, 'july', 2, 110.6);
INSERT INTO MonthSchedule (userID, monthName, expenseItemID, amount)
VALUES (4, 'august', 3, 101.5);

SELECT * FROM Users;
SELECT * FROM ExpenseItem;
SELECT * FROM ExpensesHistory;
SELECT * FROM MonthReport;
SELECT * FROM YearReport;
SELECT * FROM MonthSchedule;