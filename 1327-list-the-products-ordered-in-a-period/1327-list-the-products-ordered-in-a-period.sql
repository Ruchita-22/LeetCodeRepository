# Write your MySQL query statement below

select p.product_name, sum(o.unit) as unit
from Products p inner join Orders o 
USING(product_id) 
where extract(month from o.order_date) = 2 and extract(year from o.order_date) = 2020
GROUP BY product_id 
HAVING unit >= 100;

/*
select p.product_name, t.unit 
from Products p inner join  (
    select o.product_id as product_id, sum(o.unit) as unit
    from Orders o
    where extract(month from o.order_date) = 2 and extract(year from o.order_date) = 2020
    group by o.product_id
) as t
on p.product_id = t.product_id
where t.unit >= 100
*/


