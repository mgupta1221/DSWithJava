Following 5 problems are part of the same family:
1) Coin Change permutation
2) Coin Change Combination
3) Target Sum Subset
4) 0-1 Kanpsack
5) Unbounded Knapsack


Following 3 problems are part of the same family:
1) Longest Pallendromic SubSequence
2) Longest COmmon SubSequence
3) Edit Distance
4) Count_MinInsertionDeletionToConvert.java  - Minimum no of InsertionDeletion to convert string a to b. (Trick :find LCS and
 subtract from length of one string to get insertions... and vice versa for deletion)
5) Count_minDeleteToConvert
6) Count_DistinctSubsequences


- Diff between logic of Coin Change permutation and Combination

Agar coin repeat karna hai to Coin kar loop andar chalao - Permutation 
Afgar Coin repeat NAHI karna hai to Coin ka loop bahar chalao - Combination

- In target Sum Subset, one number will only appear once.
E.g. - For 7 target sum and given coins are 2,3,5,6
so {2,2,3} CANNOT be the answer as 2 is being repeated
Only {2,5} will be the answer

- Key note - Agar duplicacy chahiye to 1D , else use 2D

- 0-1 Knapsack is same as Target Sum Subset, just that Knapsack has weights and values concept.

- Differnece between 0-1 and Unbounded Knapsack is:
 in 0-1 Knapsack duplicacy is NOT allowed  - (hence solved with 2D)
 in unbounded Knapsack duplicacy is allowed - (hence solved with 1D)

- Comparison video of Coin Change permutation, Combination and Target Sum Subset: 
https://www.youtube.com/watch?v=JyyS9mlMcr4&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=15


- Check "Count Encoded Strings" question in DP
// Solution Video- 
https://www.youtube.com/watch?v=jFZmBQ569So&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=20


- Important on DP solutions
1) First columns and rows are generally kept empty in DP 2-D arrays
so if you talk of dp[i][j]...you are filling for word[i-1][j-1]
See diagram EditDistance.png in this "DP" folder

2)One important thing about base conditions is if there are 2 base conditions , in one condition you are returning 1 and in other you are  returning zero  - always put the one returning 1 above the one returning 0.
E.g. Count_DistinctSubsequences (LC 115) quesiton of DP.




