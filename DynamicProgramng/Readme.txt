// Dynamic Programing

2 ways to identify DP problems / How to idenitfy the problems in which DP can be applied:

1) Neeche aate hue solve hoti hai
2) Same problem baar baar solve ho rhi hogi - pass quesitonBank instead of solving again and again

===========================
2 Tricks of DP
1) Momoization -(Check Fibonacci question)
2) Tabulation - (Check ClimbingStairs question)

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

1. Target Sum Subset
2. Coin Change Combination
3. Coin Change Permutation
4. Zero One Kanpsack
5. Unbounded Kanpsack

Check them in the same order






