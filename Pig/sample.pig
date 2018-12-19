A = Load '/home/chaithra/marks.txt' using PigStorage (' ') as (Index: int, Name: chararray, Subject: chararray, Marks: int);
B = FOREACH A generate Index, Name, Subject, Marks;
Dump B; 
