SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;

begin; --2
update students set student_name='mk' where student_id=1; --2
rollback; --4


begin; --2
--B
update students set --4
student_name='XX4' where student_id=1;
commit --6

begin; --2
--E
select * from students; --4
--G
update students set student_name='ZZ2' where student_id=1; --6
rollback; --8

select * from students
