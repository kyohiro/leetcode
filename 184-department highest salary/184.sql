-- Write your MySQL query statement below
select d.Name as Department, e.Name as Employee, e.Salary
from Employee e
inner join Department d on e.DepartmentId = d.Id
inner join (
    select DepartmentId, max(Salary) as Salary
    from Employee
    group by DepartmentId
) m on e.DepartmentId = m.DepartmentId and e.Salary = m.Salary
order by Salary DESC
