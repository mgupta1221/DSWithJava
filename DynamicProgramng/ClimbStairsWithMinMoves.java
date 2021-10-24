package DynamicProgramng;

public class ClimbStairsWithMinMoves {

    // Question link:
    // https://nados.pepcoding.com/content/0/b9efd9b5-0c4b-4a0f-a3cb-68def0244e4c/

    // Question video:
    // https://www.youtube.com/watch?v=d42uDPBOXSw&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=4
    // Solution video -
    // https://www.youtube.com/watch?v=Zobz9BXpwYE&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=5

    public static void main(String[] args) {
        // int[] stairNumbers = { 2, 4, 1, 0, 2, 3 };
        int[] stairNumbers = { 1, 1, 1, 4, 9, 8, 1, 1, 10, 1 };
        countPathsWithTabulation(stairNumbers);

    }

    public static void countPathsWithTabulation(int[] arr) {

        int n = arr.length;
        Integer[] dp = new Integer[n + 1]; // Notice we are using Integer here to have 'null' as default instead of 0
        dp[n] = 0; // 0 moves to reach from n to n(not talking about paths here which will be 1)

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                int min = Integer.MAX_VALUE;

                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                } else {
                    dp[i] = null;
                }

            }
        }

        System.out.println(dp[0]);

    }

}