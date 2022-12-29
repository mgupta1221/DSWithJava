package StriverSheet.Day25_DP;

// See PepJava\DynamicProgramng\ZerOneKnapSack.java for approach description

// Weight is capacity and n is number of values

public class ZeroOne_Kanpsack {

    static int knapSack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (j < wt[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        int x = dp[i - 1][j];
                        int y = dp[i - 1][j - wt[i - 1]] + val[i - 1];

                        dp[i][j] = Math.max(x, y);
                    }
                }
            }
        }
        return dp[n][W];

    }

    public static void main(String[] args) {
        int values[] = { 1, 2, 3 };
        int weights[] = { 4, 5, 1 };

        int result = knapSack(4, weights, values, 3);
        System.out.println(result);
    }

}
