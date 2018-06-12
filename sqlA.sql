SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;

begin;--1
--A
select * from students; --3
rollback; --5

begin; --1
select * from students; --3 
--C
select * from students; --5
--D
select * from students;  --7
rollback;--8

begin; --1
select * from students; --3
--F
update students set student_name='ZZ1' where student_id=1; --5
rollback; --7
select * from students