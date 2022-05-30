REM   Script: Activity8
REM   Activity8 - SQL


-- Write an SQL statement to find the highest purchase amount ordered by the each customer with their ID and highest purchase amount.
SELECT CUSTOMER_ID, MAX(PURCHASE_AMOUNT) AS "MAX_PURCHASE" FROM ORDERS GROUP BY CUSTOMER_ID;

-- Write an SQL statement to find the highest purchase amount on '2012-08-17' for each salesman with their ID.
SELECT SALESMAN_ID, ORDER_DATE, MAX(PURCHASE_AMOUNT) AS "MAX_AMOUNT" FROM ORDERS WHERE ORDER_DATE ='17-AUG-12' GROUP BY SALESMAN_ID, ORDER_DATE ;

-- Write an SQL statement to find the highest purchase amount with their ID and order date, for only those customers who have a higher purchase amount within the list [2030, 3450, 5760, 6000].
SELECT CUSTOMER_ID, ORDER_DATE, MAX(PURCHASE_AMOUNT) AS "MAX_AMOUNT" FROM ORDERS GROUP BY CUSTOMER_ID, ORDER_DATE HAVING MAX(PURCHASE_AMOUNT) IN (2030, 3450, 5760, 6000); 



