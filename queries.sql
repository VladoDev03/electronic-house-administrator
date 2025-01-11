USE home_administrator;

SELECT * FROM company;
SELECT * FROM building;
SELECT * FROM apartment;
SELECT * FROM resident;
SELECT * FROM employee;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM building;
DELETE FROM employee;
DELETE FROM company;
DELETE FROM apartment;
DELETE FROM resident;
SET SQL_SAFE_UPDATES = 1;

SELECT e.id AS employee_id, b.id AS building_id FROM building AS b
INNER JOIN employee AS e ON e.id = b.responsibleEmployee_id