-- Last updated: 7/17/2026, 2:57:00 PM
# Write your MySQL query statement below
/* Write your T-SQL query statement below */
WITH CTE AS
(
    SELECT
        *,
        COUNT(*)OVER(PARTITION BY lat,lon) AS lat_lon_pair,
        COUNT(*)OVER(PARTITION BY tiv_2015)AS cnt_2k15
    FROM Insurance
)
SELECT 
    ROUND(SUM(tiv_2016),2) AS tiv_2016
FROM CTE
WHERE lat_lon_pair = 1 AND cnt_2k15 > 1