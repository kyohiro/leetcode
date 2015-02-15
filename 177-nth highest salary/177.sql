CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    # Write your MySQL query statement below.
    select distinct(Salary)
        from Employee e
        where N-1 = (select count(distinct(Salary)) from Employee m where m.Salary > e.Salary)
   );
END
