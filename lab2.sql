--1
--select distinct g.STUDENT_ID,count(*),subject_id from grades g join students s on g.STUDENT_ID=s.STUDENT_ID where exists(select grade from grades) group by STUDENT_ID,subject_id

--2 a
--select PROJECT_ID,PROJECT_NAME from projects s join employees e on s.MANAGER_ID=e.EMPLOYEE_ID group by e.EMPLOYEE_ID,project_id,project_name having count(distinct e.EMPLOYEE_ID)<=3

--2b corr
--select distinct PROJECT_NAME,count(employee_id) from projects s join allocations a on s.PROJECT_ID=a.PROJECT_ID group by employee_id,project_name 


--3a
--select STUDENT_ID,DATE_OF_BIRTH,student_name from students where GENDER ='M' and DATE_OF_BIRTH < any(select DATE_OF_BIRTH from employees e join teams t on e.TEAM_ID=t.TEAM_ID where TEAM_NAME='SOFTWARE' group by DATE_OF_BIRTH ) 

--3b
--select s.STUDENT_ID,s.STUDENT_NAME,grade from students s join majors m on s.MAJOR_ID=m.MAJOR_ID join grades g on s.STUDENT_ID=g.STUDENT_ID where MAJOR_NAME='COMPUTER SCIENCE'
--and grade>(select max(grade) from majors m join students s on m.MAJOR_ID=s.STUDENT_ID join grades g on s.STUDENT_ID=g.STUDENT_ID where MAJOR_NAME='ROBOTICS')

--3c
--select project_id,manager_id from employees e join allocations a on e.EMPLOYEE_ID=a.EMPLOYEE_ID not in
--(join positions p1 on p1.POSITION_ID=a.POSITION_ID where p1.POSITION_NAME='manager' join projects p2 on p1.PROJECT_ID=p2.PROJECT_ID) 

--4a
--select count(grade),stu.STUDENT_NAME,g.STUDENT_ID from grades g join subjects s on g.SUBJECT_ID=s.SUBJECT_ID join students stu on stu.STUDENT_ID=g.STUDENT_ID group by stu.STUDENT_NAME,g.STUDENT_ID

--4b corr
--select DISTINCT EMP_NAME,e.EMPLOYEE_ID,a.PROJECT_ID,s.AMOUNT from employees e join salaries s on e.EMPLOYEE_ID=s.EMPLOYEE_ID join allocations a on e.EMPLOYEE_ID=a.EMPLOYEE_ID where s.AMOUNT>0 

--5 corr
--select p.PROJECT_ID,PROJECT_NAME,count(e.EMPLOYEE_ID) from employees e join projects p on e.EMPLOYEE_ID=p.MANAGER_ID join allocations a on a.EMPLOYEE_ID=e.EMPLOYEE_ID group by e.EMPLOYEE_ID,p.PROJECT_NAME,p.PROJECT_ID

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
--select EMP_NAME,DATE_OF_BIRTH from employees e join TEAMS t on e.TEAM_ID=t.TEAM_ID order by DATE_OF_BIRTH DESC
select employee_id, 

--8
--select distinct a.EMPLOYEE_ID,EMP_NAME from employees e join allocations a on e.EMPLOYEE_ID=a.EMPLOYEE_ID WHERE PROJECT_ID not in (select PROJECT_ID from projects s join employees e on s.MANAGER_ID=e.EMPLOYEE_ID where e.EMPLOYEE_ID in(select EMPLOYEE_ID from employees where EMP_NAME='INDEPENDENT') )
--select PROJECT_ID from projects s join employees e on s.MANAGER_ID=e.EMPLOYEE_ID where e.EMPLOYEE_ID in(select EMPLOYEE_ID from employees where EMP_NAME='INDEPENDENT') 
--select EMPLOYEE_ID from employees where EMP_NAME='INDEPENDENT'

--9
--select EMP_NAME,PROJECT_ID from employees e join projects p on e.EMPLOYEE_ID=p.MANAGER_ID