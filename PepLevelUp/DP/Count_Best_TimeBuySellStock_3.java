package PepLevelUp.DP;

public class Count_Best_TimeBuySellStock_3 {

    // Problem:(With Tansaction fees)
    // https://www.geeksforgeeks.org/maximum-profit-after-buying-and-selling-the-stocks-with-transaction-fees/
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    // LC 714

    // Note: Mulitple transactions are allowed WITH Transaction fees

    // Solution video:
    // https://www.youtube.com/watch?v=DzH4kVcyuOI
    // Solution approach:
    //

    // Trick Diagram:

    public static int maxProfitWith_Txnfees(int[] prices, int fee) {

        int maxPrfit = 0;
        int[][] dp = new int[prices.length][2];
        // We have created a dp which will be of 2 columns [0] and [1]
        // Column [0] means 'Buy' and Culumn[1] means 'Sell'
        // We will incur transaction fees on each Buy(not while sell)

        // In the dp, we will store the "Profit" after transaction

        // here we are filing initial Buy value...we are entering the market with 0
        // rupees
        // Price[0] is the value that you will buy the stock in this case for the first
        // time so net amount left with you will have (-prices[0]) - fee
        dp[0][0] = -(prices[0]) - fee;

        // here we are filing initial Sell value.
        // You cannot sell the stock on the same day(given in the question) so first
        // sell value will be 0
        dp[0][1] = 0;

        for (int i = 1; i < dp.length; i++) {
            // Buy case - You have 2 options, either you hold the stock that was bought
            // previously, or, you buy the stock now

            // Case 1: Holding the stock purchsed previously(not buying), since there is no
            // new operation
            // we will copy the previous buy value
            int x1 = dp[i - 1][0];
            // Case 2: Buying the stock, take the last profit made (dp[i-1][1]) minus
            // current buying price the
            // price minus Txn fees
            int y1 = dp[i - 1][1] - prices[i] - fee;
            // Take max of the two
            dp[i][0] = Math.max(x1, y1);

            // Sell case
            // Case 1: Holding the stock, copy the last sell price
            int x2 = dp[i - 1][1];
            // Case 2: Selling the stock now, means you must have bought it the previous day
            // and add the current price value
            int y2 = dp[i - 1][0] + prices[i];
            dp[i][1] = Math.max(x2, y2);

        }

        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {

        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        int result = maxProfitWith_Txnfees(prices, fee);
        System.out.println(result);
    }
}
