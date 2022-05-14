package PepLevelUp.DP;

public class Count_Best_TimeBuySellStock_1 {

    // Problem:
    // https://www.geeksforgeeks.org/best-time-to-buy-and-sell-stock/
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    // Note: Only one transaction is allowed

    // Solution:
    // https://www.youtube.com/watch?v=4YjEHmw1MX0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=32

    // Solution Approach:
    // Pehle buy hogi fir sell hogi
    // har din par calaulate karenge , maximum profit kitna ban sakta hai
    // isko caclulate karne ke liye loop chalao or ith index ko selling day consider karke
    // usse pehle ke numbers ka(0 to i-1) least maintian rakho or profit nikalte raho
    // maxProfit ab tak calculate karte raho
    // last mai wahi answer hoga

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = Integer.MAX_VALUE;
        int currentProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // this will maintian least buying cost from 0 to i-1
            minBuy = Math.min(minBuy, prices[i - 1]);

            // calculating current Profit considering today as the selling day
            currentProfit = prices[i] - minBuy;

            // this will maintian maximum proft achieved till date
            maxProfit = Math.max(currentProfit, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int result = maxProfit(prices);
        System.out.println(result);
    }
}
