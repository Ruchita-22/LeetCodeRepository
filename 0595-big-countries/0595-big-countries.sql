# Write your MySQL query statement below
select name, population, area
from World w
where w.area >= 3000000 || w.population >= 25000000