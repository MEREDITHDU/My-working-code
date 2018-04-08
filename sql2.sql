--3
--select SUBJECT_NAME from subjects where SUPERVISOR_ID=(SELECT EMPLOYEE_ID from employees where EMP_NAME='JOHNNY')

--4
--select c.ROOM_ID,START_TIME from classrooms c join schedules s on c.ROOM_ID=s.ROOM_ID where START_TIME<14

--5
--select SUBJECT_NAME,SUB_TYPE_ID from subjects s join schedules ch on s.SUBJECT_ID=ch.SUBJECT_ID where ROOM_ID in(2,4)

--6
--select EMP_NAME from employees where EMPLOYEE_ID in(select EMPLOYEE_ID from schedules where ROOM_ID in (select ROOM_ID from classrooms where ROOM_SIZE>20 and SCREEN='Y')) order by EMP_NAME ASC
--select EMPLOYEE_ID from schedules where ROOM_ID in (select ROOM_ID from classrooms where ROOM_SIZE>20 and SCREEN='Y')

--7
--select SUBJECT_NAME from subjects s join employees e on s.SUPERVISOR_ID=e.EMPLOYEE_ID where EMPLOYEE_ID in(select EMPLOYEE_ID from schedules where DAY_OF_WEEK='MON' and START_TIME=10)
--select t.TEAM_ID from teams t join employees e on t.TEAM_ID=e.TEAM_ID where EMPLOYEE_ID in(select EMPLOYEE_ID from schedules where DAY_OF_WEEK='MON' and START_TIME=10)

--8
--select SUBJECT_NAME, SUPER_SUB_ID from subjects 

--9
--select count(*) from subjects s join employees e on s.SUPERVISOR_ID=e.EMPLOYEE_ID where EMP_NAME='JOHNNY'

--10
--select min(DATE_OF_BIRTH) from employees e join subjects s on e.EMPLOYEE_ID=s.SUPERVISOR_ID 

--11
--select max(ROOM_SIZE) from classrooms c join schedules s on c.ROOM_ID=s.ROOM_ID where START_TIME in(12,16) and DAY_OF_WEEK='MON'

--12
--select count(DISTINCT SUBJECT_ID),ROOM_ID from schedules group by ROOM_ID

--13
--select avg(GRADE),SUBJECT_ID from grades group by SUBJECT_ID

--14
--SELECT count(*),SUPERVISOR_ID from subjects group by SUPERVISOR_ID

--15
--select SUBJECT_NAME,count(*) FROM SUBJECTS s join employees e on s.SUPERVISOR_ID=e.EMPLOYEE_ID group by SUBJECT_NAME
--SELECT SUPERVISOR_ID FROM SUBJECTS WHERE SUBJECT_NAME='DATABASES'

--16
--select EMP_NAME,count(*) FROM employees e join schedules s on e.EMPLOYEE_ID=s.EMPLOYEE_ID where DAY_OF_WEEK=' MON'group by EMP_NAME having (select count(*)>1)

--17
--select SUBJECT_NAME from subjects s join schedules ch on s.SUBJECT_ID=ch.SUBJECT_ID group by SUBJECT_NAME having count(ROOM_ID)>1

--18
--select SUBJECT_NAME, DATE_OF_BIRTH from SUBJECTS s join EMPLOYEES e on s.SUPERVISOR_ID=e.EMPLOYEE_ID group by SUBJECT_NAME, DATE_OF_BIRTH having DATE_OF_BIRTH <(select DATE_OF_BIRTH from EMPLOYEES where EMP_NAME='JOHNNY')

--19
--SELECT DISTINCT EMP_NAME,avg(AMOUNT) from EMPLOYEES E JOIN SALARIES S ON E.EMPLOYEE_ID=S.EMPLOYEE_ID GROUP BY EMP_NAME,AMOUNT having AVG(AMOUNT)<(select AVG(AMOUNT) from SALARIES where EMPLOYEE_ID=(select EMPLOYEE_ID from EMPLOYEES where EMP_NAME='MESUREA')) order by avg(AMOUNT) asc


--20
--select SUBJECT_NAME from subjects
--SELECT SUPERVISOR_ID from subjects  WHERE SUBJECT_NAME='ALGEBRA'
--SELECT TEAM_ID FROM EMPLOYEES where EMPLOYEE_ID=1
--select count(*) from teams t join employees e on t.TEAM_ID=e.TEAM_ID group by TEAM_ID