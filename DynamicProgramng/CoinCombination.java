package DynamicProgramng;

public class CoinCombination {

    // Question link:
    // https://nados.pepcoding.com/content/0/66e4763d-5af1-4388-89fb-828618e75a30/

    // Question video:
    // https://www.youtube.com/watch?v=Ph1EB07Q4pA&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=12
    // Solution video -
    // https://www.youtube.com/watch?v=l_nR5X9VmaI&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=13

    // (uses 1DArray to solve)
    public static void main(String[] args) {

        int[] coins = { 2, 3, 5 };
        int targetAmount = 7; // so possible combinations are {2,2,3} and {2,5}
        // and hence answer should be 2
        // Notice here we are looking for combination and NOT 'permutations'
        // For permutation-  {232}, {3,2,2}, {5,2} would also be counted

        int[] dp = new int[targetAmount + 1];// this dp will store the no of possible coin combinations that add up to
                                             // ith index
        // e.g. dp[4] will store no of posibsle coin combinations jinka total 4 hota ho
        dp[0] = 1;

        // looping through coins
        for (int i = 0; i < coins.length; i++) {
            // looping from ith index till end
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[targetAmount]);

    }

}