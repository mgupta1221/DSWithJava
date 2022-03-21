// Dynamic Programing

2 ways to identify DP problems / How to idenitfy the problems in which DP can be applied:

1) Neeche aate hue solve hoti hai
2) Same problem baar baar solve ho rhi hogi - pass quesitonBank to avoid solving again and again

===========================
2 Tricks of DP
1) Momoization -(Check Fibonacci question)
2) Tabulation - (Check ClimbingStairs question, TargetSumSubsets, Knapsack, etc)

In Momoization, we uses Questionbank

In tabulation,- We DO NOT use recursion, we use iterative logic to solve problem in this approach

If the arraySize in question is of length 6, than we create an array of size 7 (n+1)

3 steps to implement Tabulation:

 Step 1: Storage and assign Meaning to each cell.
 i.e. create a new array of size n+1 and assign meaning to each cell of this array, where 
 meaning is e.g. for cell 4, 4 se 0 pe jane ke kitne raste hain

 Step 2:Direction of problem
 For this, you have to identify badi problem kidhar hai or choti kidhar..
 Choti side se shuru karna hai
 0th step se 0th step pe jana choti problem hai vs. 0th se topmost stair pe jaana

 Step 3: Travel and solve

 See video for details fo tabulation approach:
 https://www.youtube.com/watch?v=A6mOASLl2Dg&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=2


 
 - Below 5 DP questions take same logic:
 //Base Approach explained here: https://www.youtube.com/watch?v=tRpkluGqINc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=11

1. Target Sum Subset  (uses 2D-array to solve)
2. Coin Change Combination   (uses 1D-array to solve)
3. Coin Change Permutation   (uses 1D-array to solve)
4. Zero One Knapsack
5. Unbounded Knapsack

6. Paint N houses





Check them in the same order

See the diagram attached for TargetSum and Knapsack problems whose solution approaches 
are similar- For 2D array, analogy is item ne batting ki vs usne batting nahi ki.

Agar nahi ki- to upar wala column ka item seedha copy ho jayega...which reflect the score made by 
all items above it
Aur agar ki  - to maximum lena hoga upar wala item vs. his score + scored by other players by moving left
in row above 


-Difference between TargetSum and CoinChange problems(Comb. and Permu.) is in CoinChange problems
you have infinite supply of coins so number can repeat, however in TargetSum numbers wont repeat.



-When to use 1D array vs when to use 2D array
Where repetation of values is allowed - use 1D array (ex: CoinChange Combination or CoinChange Permutation prblms)
Where repetation of values is NOT allowed - use 2D array (ex: Coin Comnination or CoinPermutation prblms)




-  Difference between ZeroOne Knapsack and Unbounded knapsack is in ZeroOne knapsack 
items cannot repeat however in UnBounded Knapsack they can repeat. So check both the solutions

- Another good explanation about what is the differnece in solution of these 5 
problems(1-D vs 2D array) is explanied in Unbounded Knapsack problem video.
https://www.youtube.com/watch?v=jgps7MXtKRQ&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=17







