select d.Name as 'Department', e.Name as 'Employee', e.Salary as 'Salary'
from Employee e join on Department d on e.DepartmentId=d.id
where (
select count(distinct e2.Salary) from Employee e2
where e.Salary < e2.Salary and e2.DepartmentId=e.DepartmentId) < 3
order by d.name, e.Salary desc ;