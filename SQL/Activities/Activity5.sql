REM   Script: Activity5
REM   Activity5 - SQL

-- Update the grade score of salesmen from Rome to 200.
UPDATE salesman SET grade=200 WHERE SALESMAN_CITY = 'Rome'

-- Update the grade score of James Hoog to 300.
UPDATE salesman SET grade=300 WHERE SALESMAN_NAME = 'James Hoog'

-- Update the name McLyon to Pierre.
UPDATE salesman SET SALESMAN_NAME='Pierre' WHERE SALESMAN_NAME = 'McLyon'

SELECT * FROM salesman;


