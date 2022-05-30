REM   Script: Activity4
REM   Activity4 - SQL


-- Add the grade column
ALTER TABLE salesman add grade int; 

-- Set the value in the grade column for everyone to 100.
UPDATE salesman set grade=100;

-- Use SELECT command to display the results.
SELECT * FROM salesman;

