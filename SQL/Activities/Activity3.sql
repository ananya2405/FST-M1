REM   Script: Activity3
REM   Activity3 - SQL


-- Show data from the salesman_id and salesman_city columns
SELECT salesman_id, salesman_city FROM  salesman;

-- Show data of salesman from Paris
SELECT * FROM salesman WHERE SALESMAN_CITY = 'Paris';

-- Show salesman_id and commission of Paul Adam
SELECT salesman_id, commission FROM  salesman WHERE  SALESMAN_NAME = 'Paul Adam';

