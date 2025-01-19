DROP DATABASE home_administrator;

USE home_administrator;

DESCRIBE service;

SELECT * FROM company;
SELECT * FROM building;
SELECT * FROM apartment;
SELECT * FROM employee;
SELECT * FROM resident;
SELECT * FROM service;
SELECT * FROM payment;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM service;
DELETE FROM building;
DELETE FROM employee;
DELETE FROM company;
DELETE FROM apartment;
DELETE FROM resident;
DELETE FROM payment;
SET SQL_SAFE_UPDATES = 1;

SELECT e.id AS employee_id, b.id AS building_id FROM building AS b
INNER JOIN employee AS e ON e.id = b.responsible_employee_id;

SELECT e.id AS employee_id, c.id AS company_id FROM company AS c
INNER JOIN employee AS e ON e.company_id = c.id;

SELECT a.id AS apartment_id, b.id AS building_id FROM building AS b
INNER JOIN apartment AS a ON a.building_id = b.id;

SELECT
    b.id AS building_id,
	e.id AS employee_id,
    c.id AS company_id,
    a.id AS apartment_id
FROM building AS b
INNER JOIN employee AS e ON e.id = b.responsible_employee_id
INNER JOIN company AS c ON e.company_id = c.id
INNER JOIN apartment AS a ON a.building_id = b.id;

SELECT
    b.id AS 'building id',
    b.address AS 'building address',
	e.id AS 'employee id',
	e.first_name AS 'first name',
	e.last_name AS 'last name',
    c.id AS 'company id',
    c.name AS 'company name',
    a.id AS 'apartment id',
    a.apartment_number AS 'apartment number'
FROM building AS b
INNER JOIN employee AS e ON e.id = b.responsible_employee_id
INNER JOIN company AS c ON e.company_id = c.id
INNER JOIN apartment AS a ON a.building_id = b.id;