 - In merge sort,  always make sure  to use 'if' and not 'while' else it will be infinite loop

 - In merge Intervals quesitons, we can also sort the array by strat time using below way, insteadof creating the class:

  Arrays.sort(intervals, (a, b) -> a[1] - b[1]);