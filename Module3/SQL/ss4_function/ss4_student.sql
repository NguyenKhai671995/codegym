use student;

-- cau 1 -- 
select *
from Subjects
where Credit = (select max(Credit) from Subjects);

-- 2 -- 

select * from subjects
join mark on subjects.SubId = mark.SubId
where Mark = (select max(Mark) from subjects join mark on subjects.SubId = mark.SubId);

-- 3 -- 
select StudentName, Phone, Address, avg(mark) from student 
join mark  on mark.StudentId= student.StudentId
group by student.StudentId
ORDER BY avg(mark) DESC;

            