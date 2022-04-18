- Check Combination and permutation questions

- In "CoinCombinationsSingleNInfinite.java" there are 2 ways through which 
"CombinationSingle" is solved in the file
i)  Using recursion with For Loop
ii) Using susequence way - 1 bar coin lo , ek baar mat lo

List<List<Integer>> result=new ArrayList<List<Integer>>(); // creating list of list
Above line can also be written as:
List<List<Integer>> ans = new ArrayList<>();   //notice nothing in Angular bracket

List<Integer> tempResult=new  ArrayList<Integer>(); // creating list

 result.add(new ArrayList<>(tempResult)); //adding list to a list object

-All questions related to 'Permutations' will be solved using the same logic as given in 
 CoinPermutationsSingleNInfinite.java

-All questions related to 'Combinations' will be solved using the same logic as given in 
 CoinCombinationsSingleNInfinite.java

 - To print all permutations, we use swapping logic in backtracking mode as given in below link
//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

 - Way to remove last element from ArrayList
 arrlist.remove(arrlist.size()-1);

 - Int to character array
 char[] charArray = str.toCharArray();
 
