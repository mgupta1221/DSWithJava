package DynamicProgramng;

public class UnboundedKnapsack {
    public static void main(String[] args) {

        // Differece between ZeroOne Knapsack and Unbounded knapsack is in ZeroOne
        // knapsack items cannot repeat however in UnBounded Knapsack they can repeat

        // Solution video:
        // https://www.youtube.com/watch?v=jgps7MXtKRQ&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=17

        int[] weights = { 2, 5, 1, 3, 4 };
        int[] val = { 15, 14, 10, 45, 30 };

        int cap = 7;

        // Since numbers can repeat, we have to use 1-D DP array
        int[] dp = new int[cap + 1];
        dp[0] = 0;
        // capacity
        for (int cp = 1; cp < dp.length; cp++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < weights.length; j++) {
                if (weights[j] <= cp) {
                    int temp = dp[cp - weights[j]] + val[j];
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
            dp[cp] = max;
        }

        System.out.println(dp[cap]);

    }
}