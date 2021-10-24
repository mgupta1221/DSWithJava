package DynamicProgramng;

public class TargetSumPathsWithDP {
    // Print true or false, if there is a subset of elements whcih add to the target
    // sum

    // In case of subset, each element has a choice to appear in the result or not
    // appear
    // So total number of subsets of a given number of length n is 2^n.
    // See video for explanation

    // Question link:
    // https://nados.pepcoding.com/content/0/c6b8409e-63e4-4f6a-a43f-18078ce913a5/

    // Question video:
    // https://www.youtube.com/watch?v=CqEsqfidKi0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=10
    // Solution video -
    // https://www.youtube.com/watch?v=tRpkluGqINc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=11

    public static void main(String[] args) {

        int[] arr = { 12, 5, 2, 7,4 };
        int sum = 10;

        targetSumWithDP(arr, sum);
    }

    public static void targetSumWithDP(int[] arr, int targetSum) {
        boolean[][] dp = new boolean[arr.length + 1][targetSum + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        var arrVal = arr[i - 1];
                        if (j >= arrVal) {
                            if (dp[i - 1][j - arrVal] == true) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }

            }

        }
        System.out.println(dp[arr.length][targetSum]);
    }

}