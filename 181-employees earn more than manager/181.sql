select p.Name as Employee
from Employee p
left join Employee m on p.ManagerId = m.Id
where p.Salary > m.Salary
and p.ManagerId is not null
