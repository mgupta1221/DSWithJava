package PepLevelUp.DP;

public class TargetSumSubset {
    // Print true or false, if there is a subset of elements whcih add to the target
    // sum

    // Solved using Iterative DP
    // This uses 2D array unlike Coin Change (which uses 1 D array for DP iterative
    // solution)

    // - Key note - Agar duplicacy chahiye to 1D , else use 2D array

    // So total number of subsets of a given number of length n is 2^n.
    // See video for explanation

    // Problem
    // https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

    // Question video:
    // https://www.youtube.com/watch?v=CqEsqfidKi0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=10
    // Solution video -
    // https://www.youtube.com/watch?v=tRpkluGqINc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=11

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

    // Trick diagram: TargetSumSubset.png

    public static boolean TargetSumSubset_Iterative(int[] arr, int targetSum) {
        boolean[][] dp = new boolean[arr.length + 1][targetSum + 1];

        // 'i' in loop below will be numbers through which combination has to be made
        // 'j' will be loop from 0 to target sum
        // remember 'i' will start with 0 value to solve this problem than all nums will
        // come(see trick diagram- TargetSumSubset.png)
        // meanning of each cell is kya {4,2,7} ka koi combination hai jo 5 ka
        // cimbination banaye
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0 && j == 0) { // empty array(first row) mai koi aisa subset jo '0' ka sum bana sake? Answer is
                                        // yes, logic given is x^0 =1
                    dp[i][j] = true;
                } else if (i == 0) { // empty array(first row) mai koi aisa subset jo '1 to targetSum' ka sum bana
                                     // sake? Answer is no becuase empty array se 0 chhod ke kuch nahi banaya ja
                                     // sakta
                    dp[i][j] = false;
                } else if (j == 0) {// talking about first column E.g. 4 kitno ke subset mai aa sakta hai? ya to 4
                                    // aayega ya nahi aayega- Agar nahi aayega to 0 sum to ban hi jayega isliye true
                                    // thats why 0 sum can be made with any value
                    dp[i][j] = true;
                } else {
                    // 2 possibilities here- ya to number aayega ya nahi aayega
                    // agar number NAHI aayega to upper row [i-1][j] wala answer copy ho jayega
                    // kyunki baaki y-axis ke sab upar wale numbers ko target banana padega
                    // agar upar walon ne mil kar sum already bana liya hai to answer to true ho hi
                    // jayega na
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        // agar number aayega to upar wali row mai x cells left jayenge//
                        // where x is current target(column value) minus nums[i-1]( jo number aane ki
                        // keh rha hai row side se)
                        // See video for explanation of this
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
        return dp[arr.length][targetSum];
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 13, 6 };
        int target = 9;

        boolean result = TargetSumSubset_Iterative(nums, target);
        System.out.println(result);
    }
}
