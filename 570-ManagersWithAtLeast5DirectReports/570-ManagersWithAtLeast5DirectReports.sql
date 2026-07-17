-- Last updated: 7/17/2026, 2:57:05 PM
# Write your MySQL query statement below
SELECT E1.name
FROM Employee E1
JOIN (
    SELECT managerId, COUNT(*) AS directReports
    FROM Employee
    GROUP BY managerId
    HAVING COUNT(*) >= 5
) E2 ON E1.id = E2.managerId;