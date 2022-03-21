package DynamicProgramng;

public class MinCostPathIn2D {

    // Question link:
    // https://nados.pepcoding.com/content/0/a3b6281c-20d6-4bc3-87fc-a88d93d6f1b4/

    // Question video:
    // https://www.youtube.com/watch?v=D-0souJUBMU&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=6
    // Solution video -
    // https://www.youtube.com/watch?v=BzTIOsC0xWM&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=7

    public static void main(String[] args) {
        // Taking automated hardcoded Input
        int m = 2;
        int n = 2;

        var str = "3 1 4 3";
        String[] elementsInArrayFormat = str.split(" ");
        int[][] arr = new int[m][n];
        int conter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(elementsInArrayFormat[conter]);
                conter++;
            }
        }

        minCostPath(arr);
    }

    public static void minCostPath(int[][] arr) {

        int[][] dp = new int[arr.length][arr[0].length];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + arr[i][j];
                }

            }
        }
        System.out.println(dp[0][0]);
    }

}