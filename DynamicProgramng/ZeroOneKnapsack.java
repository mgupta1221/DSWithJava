package DynamicProgramng;

public class ZeroOneKnapsack {
    public static void main(String[] args) {

        int[] weights = { 2, 5, 1, 3, 4 };
        int[] val = { 15, 14, 10, 45, 30 };
        int len = val.length;
        int cap = 7;

        // Since numbers should not repeat(each item of val[] array should appear once
        // in the output), we have to use 2-D DP array
        int[][] dp = new int[len + 1][cap + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    // if current number does not do batting
                    if (j < weights[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } // if current number bats
                    else {
                        int remCapacity = j - weights[i - 1];
                        // If he bats, final DP number should be maximum of when he bats(along with
                        // scores that others make) and when he does not bat
                        if (dp[i - 1][remCapacity] + val[i - 1] > dp[i - 1][j]) {
                            dp[i][j] = dp[i - 1][remCapacity] + val[i - 1];
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }

                }

            }
        }
        System.out.println(dp[len][cap]);

    }
}