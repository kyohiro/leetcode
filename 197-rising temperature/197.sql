# Write your MySQL query statement below
select w1.Id
from Weather w1
inner join Weather w2 on w1.Date = DATE_ADD(w2.Date,INTERVAL 1 DAY) and w1.Temperature > w2.Temperature
order by w1.Id