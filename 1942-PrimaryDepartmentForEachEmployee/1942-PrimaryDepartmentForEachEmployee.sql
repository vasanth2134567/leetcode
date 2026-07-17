-- Last updated: 7/17/2026, 2:55:59 PM
SELECT employee_id, department_id
FROM Employee 
WHERE primary_flag = 'Y'
UNION
SELECT employee_id, department_id
FROM Employee 
GROUP BY employee_id
HAVING COUNT(employee_id) = 1
ORDER BY employee_id;