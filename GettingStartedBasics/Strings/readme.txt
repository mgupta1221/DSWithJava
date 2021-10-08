1) See Toggle Case question


2) See RemovePrimes Video- One issue which happens is if we remove elements from an array, index of all elements get reduce by 
1 so tthe immediate next element is missed

 1 2 4 5 10   //say these are numbers and if we remove 4(index 2)

 Now the index of 5 and 10 will be 2 and 3 respectively. and in a loop doing ++ will make the next index to 3 hence number 5 
 will be missed.

 Soltuion to this is iterate from right rather than left side.

 3) ArrayList  - Element retriaval, Element removal are used in RemovePrime question


