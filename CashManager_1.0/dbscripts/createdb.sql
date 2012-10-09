-- Drop tables if they exist
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS CashCostHistory;
DROP TABLE IF EXISTS CostItem;			

-- Create tables
CREATE TABLE Users (
	userID INTEGER PRIMARY KEY NOT NULL,
	name VARCHAR(100),
	password VARCHAR(10),
	balance FLOAT,
	email VARCHAR(255)
);

CREATE TABLE CashCostHistory (
	cashCostHistoryID INTEGER PRIMARY KEY NULL,
	
);