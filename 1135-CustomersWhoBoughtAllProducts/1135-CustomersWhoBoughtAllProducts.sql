-- Last updated: 7/17/2026, 2:56:39 PM
# Write your MySQL query statement below
SELECT 
    customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT(product_key))=(
    SELECT COUNT(*) FROM Product
);