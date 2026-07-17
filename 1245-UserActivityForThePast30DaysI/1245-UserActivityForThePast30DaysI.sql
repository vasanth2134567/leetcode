-- Last updated: 7/17/2026, 2:56:30 PM
select activity_date as day, count(distinct(user_id)) as active_users
from activity
where (activity_date > "2019-06-27" and activity_date <= "2019-07-27")
group by activity_date