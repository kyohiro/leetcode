select distinct(l3.Num) as Num
from Logs l3
inner join Logs l2 on l3.Id+1 = l2.Id 
inner join Logs l1 on l3.Id+2 = l1.Id
where l3.Num = l2.Num
and l3.Num = l1.Num
