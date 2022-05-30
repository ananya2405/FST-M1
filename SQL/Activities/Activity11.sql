REM   Script: Activity11
REM   Activity11 - SQL


-- Write a query that produces the name and number of each salesman and each customer with more than one current order. Put the results in alphabetical order
SELECT CUSTOMER_ID, CUSTOMER_NAME from customers a
WHERE (select count(*) from orders b where a.CUSTOMER_ID = b.CUSTOMER_ID)>1
union 
SELECT SALESMAN_ID, SALESMAN_NAME from salesman s
WHERE (select count(*) from orders b where s.SALESMAN_ID = b.SALESMAN_ID)>1
order by CUSTOMER_NAME;

-- Write a query to make a report of which salesman produce the largest and smallest orders on each date.
SELECT a.SALESMAN_ID, SALESMAN_NAME, ORDER_NO, 'highest on', ORDER_DATE from salesman a, orders b
WHERE a.SALESMAN_ID=b.SALESMAN_ID
AND b.purchase_amount=(SELECT MAX(purchase_amount) from orders c where c.ORDER_DATE = b.ORDER_DATE)
UNION
SELECT a.SALESMAN_ID, SALESMAN_NAME, ORDER_NO, 'lowest on', ORDER_DATE from salesman a, orders b
where a.SALESMAN_ID=b.SALESMAN_ID
AND b.purchase_amount=(SELECT MIN(purchase_amount) from orders c where c.ORDER_DATE = b.ORDER_DATE);






