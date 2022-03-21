package DynamicProgramng;

public class TargetSumPathsWithDP {
    // Print true or false, if there is a subset of elements whcih add to the target
    // sum

    // In case of subset, each element has a choice to appear in the result or not
    // appear (aayega ya nahi aayega)
    // So total number of subsets of a given number of length n is 2^n.
    // See video for explanation

    // Question link:
    // https://nados.pepcoding.com/content/0/c6b8409e-63e4-4f6a-a43f-18078ce913a5/

    // Question video:
    // https://www.youtube.com/watch?v=CqEsqfidKi0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=10
    // Solution video -
    // https://www.youtube.com/watch?v=tRpkluGqINc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=11

    //// (this problem uses 2D Array to solve)
    // Solution approach - number batting karega ya nahi karega

    // Agar batting nahi karega to poora total Sum previous numbers ko hi banana
    //// padega, (value of cell in row above in 2D Array)

    // Agar batting karega to totalSum-number, previous numbers ko banane padenge
    // (value of cell in row above and currentSum-number column)

    // Numbers should never repeat in TargetSumSubset and this is ensured by using
    // 2D array and number would never repeat becuase we are only taking above row
    // to copy output, say numbers are 2,3, 5 so while calculating possibility for
    // number 5 we only consider
    // This is said in below video(Coin change analysis) at 25:00 mins

    // However in CoinChange problems, we use 1D array and repetition happen

    // KEY THING IS WE DONT NEED DUPLICACY, USE 2D ARRAY
    // See readme.txt

    // Comparison video of TargetSumSubsets and Coin chagne problems-
    // https://www.youtube.com/watch?v=JyyS9mlMcr4&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=16
    public static void main(String[] args) {

        int[] arr = { 12, 5, 2, 7, 4 };
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