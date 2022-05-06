package PepLevelUp.DP;
// Differece between ZeroOne Knapsack and Unbounded knapsack is in ZeroOne

// knapsack items cannot repeat however in UnBounded Knapsack they can repeat

// Solution video:
// https://www.youtube.com/watch?v=jgps7MXtKRQ&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=17

public class UnboundedKanpsack {

    private static int UnboundedKanpsack(int[] vals, int[] weights, int capacity) {

        // Since numbers can repeat, we have to use 1-D DP array
        int dp[] = new int[capacity + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < weights.length; j++) {
                if (i >= weights[j]) {
                    int currentWeight = vals[j] + vals[i - weights[j]];
                    max = Math.max(max, currentWeight);

                }
            }
            dp[i] += max;
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weights = { 2, 5, 1, 3, 4 };
        int[] vals = { 15, 14, 10, 45, 30 };
        int capacity = 7;
        int result = UnboundedKanpsack(vals, weights, capacity);
        System.out.println(result);
    }
}
