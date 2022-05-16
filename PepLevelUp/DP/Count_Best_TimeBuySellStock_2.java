package PepLevelUp.DP;

public class Count_Best_TimeBuySellStock_2 {

    // Problem:
    // https://www.geeksforgeeks.org/stock-buy-sell/
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

    // Note: Mulitple transactions are allowed

    // Solution approach:
    // We maintian 2 variables for Buy(bp) and Sell(sp) to store indexes and loop
    // through the prices array
    // Jab tak bada elment milta rahe we keep increasing 'Sell' index , jaise hi
    // chota
    // element mil jaye Profit calculate karo arr[sp]- arr[bp] and reset bp and sp
    // to current index i
    public static int maxProfit(int[] prices) {
        int bp = 0;
        int sp = 0;
        int profit = 0;
        int maxPrfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // if next element is greater...not we are comparing adjacent elements
            if (prices[i] >= prices[i - 1]) {
                sp++;
            } else {
                // if not greater , calculate profit and maxPrfit and reset bp and sp to current i
                profit = prices[sp] - prices[bp];
                maxPrfit += profit;
                bp = sp = i;
            }

        }
        // this is important for the last element calculation
        profit = prices[sp] - prices[bp];
        maxPrfit += profit;
        return maxPrfit;

    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        // int result = maxProfit(prices);
        int result = maxProfit(prices);
        System.out.println(result);
    }
}
