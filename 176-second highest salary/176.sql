select max(Salary) as Salary
from Employee p
where Salary < (
    select max(Salary) from Employee
)
