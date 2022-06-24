INSERT INTO team6.lecturers
(lecturer_id,
first_name,
last_name,
email,
admin_or_not,
password)
VALUES
("esther",
 "Esther",
 "Tan",
 "esthertanmy@nus.edu.sg",
 TRUE,
 "esther");

INSERT INTO team6.lecturers
(lecturer_id,
first_name,
last_name,
email,
admin_or_not,
password)
VALUES
("charwah",
 "Charwah",
 "Tan",
 "cherwah@nus.edu.sg",
 FALSE,
 "charwah");


INSERT INTO team6.lecturers
(lecturer_id,
first_name,
last_name,
email,
admin_or_not,
password)
VALUES
("suriya",
 "Suriya",
 "Asaithambi",
 "suria@nus.edu.sg",
 FALSE,
 "suriya");


INSERT INTO team6.students
(student_id,
email,
first_name,
last_name,
password)
VALUES
("yeemon",
 "ymon@u.nus.edu",
 "Yee Mon",
 "Aung",
 "yeemon");


INSERT INTO team6.students
(student_id,
email,
first_name,
last_name,
password)
VALUES
("nyein",
 "nyein@u.nus.edu",
 "Nyein",
 "Kyaw",
 "nyein");

INSERT INTO team6.students
(student_id,
email,
first_name,
last_name,
password)
VALUES
("nina",
 "nina@u.nus.edu",
 "Nina",
 "Lim",
 "nina");

INSERT INTO team6.students
(student_id,
email,
first_name,
last_name,
password)
VALUES
("halim",
 "halim@u.nus.edu",
 "Halim",
 "Bin",
 "halim");

INSERT INTO team6.students
(student_id,
email,
first_name,
last_name,
password)
VALUES
("halim",
 "halim@u.nus.edu",
 "Halim",
 "Bin",
 "halim");

INSERT INTO team6.students
(student_id,
email,
first_name,
last_name,
password)
VALUES
("hanlin",
 "heily@u.nus.edu",
 "Hanlin",
 "Jiang",
 "hanlin");

INSERT INTO team6.students
(student_id,
email,
first_name,
last_name,
password)
VALUES
("xingjie",
 "xingjie@u.nus.edu",
 "XingJie",
 "Tan",
 "xingjie");

INSERT INTO team6.courses
(course_id,
actual_enroll,
course_name,
description,
size)
VALUES
("SA4110",
 10,
 "Machine Learning Application Development",
 "Machine learning (ML) is a field of inquiry devoted to understanding and building methods that 'learn', that is, methods that leverage data to improve performance on some set of tasks",
 40);

INSERT INTO team6.courses
(course_id,
actual_enroll,
course_name,
description,
size)
VALUES
("SA4105",
 1,
 "Web Application Development",
 "Creating Web Application using Spring Boot Framework",
 40);

INSERT INTO team6.courses
(course_id,
actual_enroll,
course_name,
description,
size)
VALUES
("SA4108",
 20,
 "Mobile Application Development",
 "This module introduces mobile and Web application and •Integrating Mobile application design into the existing model",
 1);

INSERT INTO team6.courses
(course_id,
actual_enroll,
course_name,
description,
size)
VALUES
("RC1000A",
 20,
 "A Culture of Respect and Consent",
 "The Respect and Consent (R&C) course seeks to raise awareness and educate students on the NUS community standards",
 20);

INSERT INTO team6.courses
(course_id,
actual_enroll,
course_name,
description,
size)
VALUES
("SE1000",
 20,
 "Student Essentials",
 "The e-module on “Student Essentials” is available to all students and staff. There are two components within the “Student Essentials” e-module.",
 20);

INSERT INTO team6.lecture_can_teach
(lecturer_id,
course_id)
VALUES
("esther",
 "SE1000");

INSERT INTO team6.lecture_can_teach
(lecturer_id,
course_id)
VALUES
("charwah",
 "SA4110");

INSERT INTO team6.lecture_can_teach
(lecturer_id,
course_id)
VALUES
("suriya",
 "SA4105");

INSERT INTO team6.lecture_can_teach
(lecturer_id,
course_id)
VALUES
("esther",
 "RC1000A");

INSERT INTO team6.lecture_can_teach
(lecturer_id,
course_id)
VALUES
("charwah",
 "SA4105");




