# Write your MySQL query statement below

(select u.name as results
from Users u
inner join MovieRating mr
on u.user_id = mr.user_id
group by  u.user_id
order by count(mr.rating) desc, u.name asc
limit 1)
union all
(
select m.title as results
from Movies m
inner join MovieRating mr
on m.movie_id = mr.movie_id
where MONTH(mr.created_at) = '02' AND YEAR(mr.created_at) = "2020" 
group by  mr.movie_id
order by avg(mr.rating) desc, m.title asc
limit 1
    )