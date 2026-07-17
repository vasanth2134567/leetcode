-- Last updated: 7/17/2026, 2:56:04 PM
-- Write your PostgreSQL query statement below
select user_id, 
    count(distinct follower_id) as followers_count
from followers
group by user_id;