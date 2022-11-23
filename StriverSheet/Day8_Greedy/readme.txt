Tip: In Meeting room problems, you might have to decide to sort tiings by Start time
 or end time. One way to decide is given in NMeetingrooms.java problem.

Tip: When you are already given a class array than how would you sort the class (since you cnanot create the class object with compareTo): 
 Ans:  Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
 -- where arr is class array say :  Job[]

Remember: 
b.profit - a.profit  - Will sort descending
a.profit - b.profit  - Will sort ascending

See Job Sequencing problem