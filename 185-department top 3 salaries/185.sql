select d.Name as Department, e.Name as Employee, e.Salary
from Employee e
inner join Department d on e.DepartmentId = d.Id
where (select count(distinct(Salary)) from Employee where DepartmentId = e.DepartmentId and Salary > e.Salary) < 3
order by e.DepartmentId, e.Salary DESC
