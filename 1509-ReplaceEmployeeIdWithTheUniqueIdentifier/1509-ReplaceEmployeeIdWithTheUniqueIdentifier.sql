-- Last updated: 7/17/2026, 2:56:12 PM
-- Write your PostgreSQL query statement below
SELECT EmployeeUNI.unique_id, Employees.name FROM Employees LEFT JOIN EmployeeUNI ON Employees.id = EmployeeUNI.id;