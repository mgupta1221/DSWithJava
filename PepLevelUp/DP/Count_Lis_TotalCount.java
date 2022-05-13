package PepLevelUp.DP;

public class Count_Lis_TotalCount {

    private static int count_No_of_Longest_Increasing_SubSeq_tab(int[] arr, int idx, int[] dp) {

        // --->
        // arr 0 | 8 | 4 | 12
        // dp] 1 | 2 | 2 | 3
        // cnt 1 | 1 | 1 | 2
        dp[0] = 1;
        int[] cnt = new int[arr.length];

        int maxlength = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1; // this represent length of LIS at index 'i'
            cnt[i] = 1; // this represent how many LIS were there at index 'i'
            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                    // first time when we reach 12 , we find 0 which is less so increase dp[12]
                    // value with 1+1=2, next we move to 8 since and dp[8]=2 so dp[12] will be
                    // updated to 2+1=3
                    // Next when we move to value 4, above < condition will not fulfil becuase
                    // dp[4]=dp[12] so we go to below ELSE loop where dp[i]=dp[j]+1, so we increse
                    // cnt[12] with cnt[j] i.e. dp[4] i.e. cnt[12]=1+1=2
                } else if (arr[j] < arr[i] && dp[i] == dp[j] + 1) { // this condition means ,
                    // this LIS already present so increase the count
                    cnt[i] += cnt[j];
                }
            }
            maxlength = Math.max(maxlength, dp[i]);
        }

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] == maxlength)
                res += cnt[i]; // take sum of cnt
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 4, 7 };

        int[] dp = new int[arr.length];
        int result = count_No_of_Longest_Increasing_SubSeq_tab(arr, 0, dp);
        System.out.println(result);
    }
}
