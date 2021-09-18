create database awdb;

use awdb;

# STUDENT TABLE ********************

create table student(
		studentId int primary key,
		firstName varchar(50),
		lastName varchar(50),
        email varchar(50),
        averageScore float
        );

select * from student;

delete from student where studentId = 10;

#drop table student;

# TEACHER TABLE ********************

create table teacher(
						teacherId int primary key,
                        teacherFirstName varchar(50),
                        teacherLastName varchar(50),
                        email varchar(50),
                        assignedTopic int,
                        foreign key (assignedTopic) references topics(topicId)
						);
                        
#drop table teachers;
                        
select * from teacher join topics on assignedTopic = topicID order by teacherId;

select * from teacher;


# TOPICS TABLE ********************

create table topics(
						topicId int primary key,
                        topicName varchar(50),
                        totalCourses int
						);
                        
select * from topics;

insert into topics values(1, "Computer science", 3);
insert into topics values(2, "History", 2);
insert into topics values(3, "Math", 3);
insert into topics values(4, "Economy", 2);
                        
# COURSES TABLE ********************

create table courses(
						courseId int primary key,
                        courseName varchar(50),
                        totalHours int,
                        id_topic int not null,
                        id_teacher int not null,
                        foreign key (id_topic) references topics(topicId),
                        foreign key (id_teacher) references teacher(teacherId)
						);
                        
select * from courses join teacher on id_teacher = teacherId
						join topics on id_topic = topicId;
                        
insert into courses values(6, "Microeconomy", 20,4,3);

# ACTIVITIES TABLE ********************
                        
create table activity(		activityId int primary key,
							id_student int not null,
                            id_course int not null,
							foreign key (id_student) references student(studentId),
							foreign key (id_course) references courses(courseId),
                            grade int
                            );
                            
                            
select * from activity;

insert into activity values (10,4,3,10);

# STUDENT SUMMARY TABLE ********************

create table summary(		student_ID int not null,
							fullName varchar(50),
							CS_grade int,
                            HS_grade int,
                            MT_grade int,
                            EC_grade int
                            );
                            
ALTER TABLE summary ADD FOREIGN KEY (student_ID) REFERENCES student(studentId);
                            
drop table summary;

set @val = 4;

set @val11 = (select concat(firstName,' ',lastName) from student where studentId = @val);
set @val12 = (select grade from activity where id_student = @val and id_course = 1);
set @val13 = (select grade from activity where id_student = @val and id_course = 2);
set @val14 = (select grade from activity where id_student = @val and id_course = 3);
set @val15 = (select grade from activity where id_student = @val and id_course = 4);

insert into summary values (@val, @val11, @val12, @val13, @val14, @val15);

select * from summary;

