package PepLevelUp.DP;

// Qustion: https://www.geeksforgeeks.org/minimize-cost-of-painting-n-houses-such-that-adjacent-houses-have-different-colors/
// Paint house : https://leetcode.com/problems/paint-house/

// Solution video: https://www.youtube.com/watch?v=kh48JLieeW8&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=23
// Trick diagram: Count_paintHouses

// This question is similar to Sum of Non-Adjacent elements solved previously 
// this was a single array question

// we will have a 2-D dp array
// har cell pe store kya karenge answer laane ke liye?
// us cell tak kitni maximum value banegi agar Red lagana jaruri hai..
// See trick diagram : [1,0] wala cell is for red...to red ko leke kitni maximum value banayi jaa sakti hai
// usko calcualte karne k liye uske 
// previous row ke dusre colors(green and blue) ki value ka minimum lena hoga (2,11) , so min is 2 and add the cells value
// i.e. 11  so 2+11=13 will be stored

public class Count_PaintHouses {

    private static int count_paintHouses(int[][] costs) {
        int[][] dp = new int[costs.length][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];// pichle row ka uthana hai to dp se uthao
            // kyunki ko pre-calculated padi hai.. is current value ko lena to main
            // array(costs) se uthao
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        int a = dp[costs.length - 1][0];
        int b = dp[costs.length - 1][1];
        int c = dp[costs.length - 1][2];
        // taking mimum of 3 from the last column
        return Math.min(a, Math.min(b, c));

    }

    public static void main(String[] args) {
        int[][] costs = { { 14, 2, 11 }, { 11, 14, 5 }, { 14, 3, 10 } };
        // int[][] costs = { {1,5,7 }, {5,8,4}, {3,2,9 }, {1,2,4 } };
        int result = count_paintHouses(costs);
        System.out.println(result);
    }
}
