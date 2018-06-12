--1
--For each student give the number of subjects in which he or she got grades.
--select distinct g.SUBJECT_ID,g.STUDENT_ID from grades g join students s on g.STUDENT_ID=s.STUDENT_ID where exists(select grade from grades) group by STUDENT_ID,Subject_id

--2 a
--Give the ids and the names of projects which are undertaken by at most three employees
--select PROJECT_ID,PROJECT_NAME from projects s join employees e on s.MANAGER_ID=e.EMPLOYEE_ID group by project_id,project_name having count(distinct employee_id)<3


--2b
--Give the names of projects which are undertaken by the least number of employees.
--select PROJECT_NAME from projects s join employees e on s.MANAGER_ID=e.EMPLOYEE_ID group by project_name having count(employee_id)=1


--3a
-- Give the ids and the names of male students, who are older than at least one employee from SOFTWARE team.
--select max(e.DATE_OF_BIRTH) from employees e join teams t on e.TEAM_ID=t.TEAM_ID where team_name='software'


--3b
--Give the ids and the names of COMPUTER SCIENCE students, who got grades higher than every ROBOTICS student in DATABASES subject.
--select s.STUDENT_ID,s.STUDENT_NAME from students s join majors m on s.MAJOR_ID=m.MAJOR_ID join grades g on s.STUDENT_ID=g.STUDENT_ID
--where major_name='computer science' and grade>
--(
--select max(grade) from majors m join students s on m.MAJOR_ID=s.MAJOR_ID
--join grades g on g.STUDENT_ID=s.STUDENT_ID where major_name='robotics'
--)

--3c
-- Check if each value of foreign key manager id from PROJECTS table matches to record from ALLOCATIONS table.
--select p.PROJECT_ID,p.MANAGER_ID,a.EMPLOYEE_ID from projects p join allocations a on p.PROJECT_ID=a.PROJECT_ID join positions s on s.POSITION_ID=a.POSITION_ID
--where s.POSITION_name='manager' and manager_id <> employee_id


--4a
--Give the ids and the names of students who haven’t got any grade yet
--select count(grade),student_name,g.STUDENT_ID
--from grades g join subjects s on g.SUBJECT_ID=s.SUBJECT_ID join students t on t.STUDENT_ID=g.STUDENT_ID
--group by student_name, g.STUDENT_ID

--4b
--Give the names of employees who haven’t been assigned to any projects but received payment(s).
--select count(a.PROJECT_ID),e.EMP_NAME from employees e join allocations a on e.EMPLOYEE_ID=a.EMPLOYEE_ID join salaries s on e.EMPLOYEE_ID=s.EMPLOYEE_ID 
--where amount>0 group by a.PROJECT_ID,EMP_NAME

--5
--Give the ids, names of projects and the number of employees who are assigned to these projects.
--select p.PROJECT_ID,p.PROJECT_NAME,count(e.EMPLOYEE_ID) from employees e join projects p on e.EMPLOYEE_ID=p.MANAGER_ID 
--join allocations a on p.PROJECT_ID=a.PROJECT_ID group by e.EMPLOYEE_ID,p.PROJECT_ID,p.PROJECT_NAME

--6a
--select p.PROJECT_ID, PROJECT_NAME, AMOUNT from projects p join salaries s on s.PROJECT_ID=p.PROJECT_ID
--create view income as 
--select p.PROJECT_ID, PROJECT_NAME, AMOUNT as info from projects p join salaries s on s.PROJECT_ID=p.PROJECT_ID
--select * from income
--update income set PROJECT_NAME='ALGEBRA' where PROJECT_ID=4
--drop view income
--select * from income

--6b
--select avg(amount),min(amount), max(amount) from salaries group by amount
--select t.TEAM_ID,TEAM_NAME,e.EMPLOYEE_ID,EMP_NAME,AMOUNT from employees e join teams t on e.TEAM_ID=t.TEAM_ID join salaries s on e.EMPLOYEE_ID=s.EMPLOYEE_ID 
--create view info as
--select t.TEAM_ID as team_id,TEAM_NAME as team_name,e.EMPLOYEE_ID as employee_id,EMP_NAME as employee_name,AMOUNT as employee_sum_of_earnings 
--from employees e join teams t on e.TEAM_ID=t.TEAM_ID
--join salaries s on e.EMPLOYEE_ID=s.EMPLOYEE_ID 
--select * from info

--7
--For each team give the names of the youngest employees.
--select e.EMP_NAME, min(e.DATE_OF_BIRTH),t.TEAM_NAME from employees e join teams t on e.TEAM_ID=t.TEAM_ID 
--group by e.DATE_OF_BIRTH,e.EMP_NAME,t.TEAM_NAME

--8
--Give the ids and the names of employees who aren’t assinged to any project which is managed by employee INDEPENDENT.
--select e.EMPLOYEE_ID,e.EMP_NAME from employees e join allocations a on e.EMPLOYEE_ID=a.EMPLOYEE_ID join projects p on e.EMPLOYEE_ID=p.MANAGER_ID
--where a.PROJECT_ID not in
 --(
 --select p.PROJECT_ID from projects p join employees e on e.EMPLOYEE_ID=p.MANAGER_ID where p.MANAGER_ID=(select e.EMPLOYEE_ID from employees where EMP_NAME='INDEPENDENT')
--)
 
--9
--Give the names of employees who were undertaking all projects with ids in range
--select e.EMP_NAME from employees e join projects p on e.EMPLOYEE_ID=p.MANAGER_ID where e.EMPLOYEE_ID between 10 and 30 and p.PROJECT_ID=all(select project_id from projects)
