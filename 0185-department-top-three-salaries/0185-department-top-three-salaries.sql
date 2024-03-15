# Write your MySQL query statement below

SELECT d1.Name AS Department, e1.Name AS Employee, Salary
FROM Employee e1 
LEFT JOIN Department d1
ON e1.DepartmentId = d1.Id
WHERE
    (    SELECT COUNT(DISTINCT Salary) 
         FROM Employee e2
         WHERE e2.DepartmentId = d1.Id AND e2.Salary >= e1.Salary
    ) <= 3
AND d1.Name IS NOT NULL
ORDER BY d1.Id DESC;