-- Last updated: 7/17/2026, 2:56:34 PM
# Write your MySQL query statement below
SELECT 
    p.project_id, 
    ROUND(AVG(e.experience_years), 2) AS average_years
FROM Project p
LEFT JOIN Employee e 
    ON p.employee_id = e.employee_id
GROUP BY p.project_id;