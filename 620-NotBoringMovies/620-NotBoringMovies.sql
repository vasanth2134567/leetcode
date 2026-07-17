-- Last updated: 7/17/2026, 2:56:52 PM
# Write your MySQL query statement below
SELECT id, movie, description, rating
FROM Cinema
WHERE id % 2 <> 0 
  AND description <> 'boring'
ORDER BY rating DESC;