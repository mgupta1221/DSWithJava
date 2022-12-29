package DynamicProgramng;

public class ZeroOneKnapsack {

    // Solution Video : https://www.youtube.com/watch?v=bUSaenttI24
    public static void main(String[] args) {

        int[] weights = { 2, 5, 1, 3, 4 };
        int[] val = { 15, 14, 10, 45, 30 };
        int len = val.length;
        int cap = 7;

        // Since numbers should not repeat(each item of val[] array should appear once
        // in the output), we have to use 2-D DP array
        int[][] dp = new int[len + 1][cap + 1];

        // 'j' is column values i.e. 0 to maximum weight
        // isliye j ka comparson hamesha weights array se hoga jab bhi hoga, values se
        // nahi
        // row has both values and weights
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    // Below 'if' condition is when current number cannot bat
                    // kyunki player jitni ball khel sakta hai (weights[i-1])..current column(j) ki
                    // value us number se kam hai to wo khel hi nahi payega

                    // to current column ke left side wale cells-- apne upar wale cell se copy ho
                    // jayenge

                    // to is case mai baaki team (upar wala cell, i.e.
                    // [same column- previous row] i.e. [i-1 , j])
                    // ne jitne run banaye honge utne hi banenge

                    // 'j' is column
                    // weights[i-1] beuase elements start from 1 and not 0
                    // i-1 hai, aur i kyun nahi liya..iska reason see video :  from 21:44 - 22:20 mins
                    if (j < weights[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    // if current number bats
                    else {
                        // For this logic- see video: from: 8:30 - 9:50 mins

                        // If he bats, final DP number should be maximum of when he bats and when he
                        // DOES NOT bat

                        int x = dp[i - 1][j]; // means he does not bat
                        int y = dp[i - 1][j - weights[i - 1]] + val[i - 1]; // means he bats and rest team plays
                                                                            // remaning balls
                                                                            // val [i-1] means khud ke run
                        dp[i][j] = Math.max(x, y);

                    }

                }

            }
        }
        System.out.println(dp[len][cap]);

    }
}