-- Last updated: 7/17/2026, 2:57:30 PM
# Write your MySQL query statement below
SELECT 
    IFNULL(
        (SELECT DISTINCT salary 
         FROM Employee 
         ORDER BY salary DESC 
         LIMIT 1 OFFSET 1), 
    NULL) AS SecondHighestSalary;