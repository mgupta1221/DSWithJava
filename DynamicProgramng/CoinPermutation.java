package DynamicProgramng;

public class CoinPermutation {

    // Question link:
    // https://nados.pepcoding.com/content/0/66e4763d-5af1-4388-89fb-828618e75a30/

    // Video :
    // https://www.youtube.com/watch?v=yc0LunmJA1A&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=14

    public static void main(String[] args) {

        int[] coins = { 2, 3, 5 };
        int targetAmount = 7; // so possible permutations are {232}, {3,2,2}, {5,2}...etc
        // Notice here we are looking for permutation and NOT combination and NOT
        // 'permutations'

        int[] dp = new int[targetAmount + 1];// this dp will store the no of possible coin combinations that add up to
                                             // ith index
        // e.g. dp[4] will store no of possible coin permutations jinka total 4 hota ho
        dp[0] = 1;
        for (int amt = 1; amt < dp.length; amt++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= amt) {
                    dp[amt] += dp[amt - coins[j]]; // e.g. dp[8]= dp[8-2] + dp[8-3] + dp[8-5];  as 2,3,5 are available coins

                }
            }
        }

        System.out.println(dp[targetAmount]);

    }

}