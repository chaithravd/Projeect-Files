Student_marks = load '/home/chaithra/marks.txt' using PigStorage (' ') as (Index: int, Name: chararray, Subject: chararray, Marks: int);
dump Student_marks; 
Student_grouping = group Student_marks by Marks;
dump Student_grouping;

