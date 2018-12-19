Student_marks = load '/home/chaithra/marks.txt' using PigStorage(' ') as (Index: int, Name: chararray, Subject: chararray, Marks: int);

Student_marks2 = load '/home/chaithra/marks1.txt' using PigStorage(' ') as (Index: int, Name: chararray, Subject: chararray, Marks: int);

Student_cogrouping = cogroup Student_marks by Marks, Student_marks2 by Marks;

dump Student_cogrouping;
