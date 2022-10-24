package StriverSheet.Day1_Arrays;

public class StocksBuyAndSell {

    // LC 121: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    // Approach:

    // Approch here is to find the minimum element to the left of the current
    // Element(minBuy) and keep finding its difference with the current Element
    // Also, keep finding the MaxProfit in the iteration.

    // Full explanation :
    //

    public static int StockBuyandSell(int[] prices) {
        int currentProfit = 0;
        int maxProfit = Integer.MIN_VALUE;
        int minBuy = Integer.MAX_VALUE;

        for (int i = 1; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i - 1]);
            currentProfit = prices[i] - minBuy;
            maxProfit = Math.max(currentProfit, maxProfit);
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };

        int maxProfit = StockBuyandSell(prices);
        System.out.println("Max profit is: " + maxProfit);

    }

}
