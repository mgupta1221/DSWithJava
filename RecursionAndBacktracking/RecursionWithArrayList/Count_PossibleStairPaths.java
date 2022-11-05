package RecursionAndBacktracking.RecursionWithArrayList;

import java.util.HashMap;

// LC 70: https://leetcode.com/problems/climbing-stairs/

public class Count_PossibleStairPaths {

    public static int climbStairs(int n) {
        // Using hashMap to avoid TLE, below there is a solution without using hashmap
        // this problem become same as Fibonacci
        HashMap<Integer, Integer> hMap = new HashMap<>();

        hMap.put(1, 1);
        hMap.put(2, 2);

        return climbStairsHelper(n, hMap);

    }

    public static int climbStairsHelper(int n, HashMap<Integer, Integer> hMap) {

        if (hMap.containsKey(n))
            return hMap.get(n);

        int result = climbStairsHelper(n - 1, hMap) + climbStairsHelper(n - 2, hMap);
        hMap.put(n, result);
        return result;

    }

    // Solution below is wihout using HashMap but will result in TLE on leetcode
    // this problem become same as Fibonacci
    // public static int climbStairs(int n) {
    // if (n == 0)
    // return 1;
    // if (n == 1)
    // return 1;
    // if (n == 2)
    // return 2;

    // return climbStairs(n - 1) + climbStairs(n - 2);
    // }

    public static void main(String[] args) {
        int result = climbStairs(4);
        System.out.println(result);
    }

}
