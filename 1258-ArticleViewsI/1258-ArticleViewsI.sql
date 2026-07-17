-- Last updated: 7/17/2026, 2:56:28 PM
# Write your MySQL query statement below
SELECT DISTINCT author_id as id 
FROM views
where author_id = viewer_id
order by id;