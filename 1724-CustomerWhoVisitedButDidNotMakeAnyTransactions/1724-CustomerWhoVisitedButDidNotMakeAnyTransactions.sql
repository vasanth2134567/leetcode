-- Last updated: 7/17/2026, 2:56:10 PM
# Write your MySQL query statement below
SELECT customer_id, COUNT(v.visit_id) as count_no_trans 
FROM Visits v
LEFT JOIN Transactions t ON v.visit_id = t.visit_id
WHERE transaction_id IS NULL
GROUP BY customer_id