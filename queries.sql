USE home_administrator;

SELECT * FROM company;
SELECT * FROM building;
SELECT * FROM apartment;
SELECT * FROM resident;
SELECT * FROM employee;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM company;
SET SQL_SAFE_UPDATES = 1;