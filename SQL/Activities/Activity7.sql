REM   Script: Activity7
REM   Activity7 - SQL


-- Write an SQL statement to find the total purchase amount of all orders.
SELECT SUM(PURCHASE_AMOUNT) AS "TOTAL_PURCHASE_AMOUNT" FROM ORDERS;

-- Write an SQL statement to find the average purchase amount of all orders.
SELECT AVG(PURCHASE_AMOUNT) AS "AVG_PURCHASE_AMOUNT" FROM ORDERS;

-- Write an SQL statement to get the maximum purchase amount of all the orders.
SELECT MAX(PURCHASE_AMOUNT) AS "MAX_PURCHASE_AMOUNT" FROM ORDERS;

-- Write an SQL statement to get the minimum purchase amount of all the orders.
SELECT MIN(PURCHASE_AMOUNT) AS "MIN_PURCHASE_AMOUNT" FROM ORDERS;

-- Write an SQL statement to find the number of salesmen listed in the table.
SELECT COUNT(DISTINCT SALESMAN_ID) AS "NO_OF_SALESMAN" FROM ORDERS;


