-- Last updated: 7/17/2026, 2:56:16 PM
# Write your MySQL query statement below
WITH DailyAmount AS (
    SELECT 
        visited_on,
        SUM(amount) AS day_amount
    FROM Customer
    GROUP BY visited_on
),
MovingMetrics AS (
    SELECT 
        visited_on,
        SUM(day_amount) OVER(ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) AS amount,
        ROUND(AVG(day_amount) OVER(ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW), 2) AS average_amount,
        ROW_NUMBER() OVER(ORDER BY visited_on) AS rn
    FROM DailyAmount
)
SELECT visited_on, amount, average_amount
FROM MovingMetrics
WHERE rn >= 7
ORDER BY visited_on ASC;