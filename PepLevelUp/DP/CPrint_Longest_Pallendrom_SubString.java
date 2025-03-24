package PepLevelUp.DP;

// LC 5
public class CPrint_Longest_Pallendrom_SubString {

    // Solution explanation:
    // https://www.youtube.com/watch?v=UflHuQj6MVA

    // Cell [i,j] represent if string formed from index i to j is pallendrome or
    // not.
    // If pallendrome than will store 1

    // We have to fill the upper half of the 2D DP array from top left to bottom
    // right hence notice the loop - middle lognest diagnal first then upper
    // diagonal than its upper diagnal like that

    // The last dp cell with value 1 will be the lenghthiest one and will be
    // returned
    // as answer

    // Trick Diagram: "CPrint_Longest_Pallndromic_SubString.png"
    private static String cprint_Longest_Pallndromic_SubString(String str) {
        String ans = "";
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for (int g = 0; g < str.length(); g++) {
            for (int i = 0, j = g; j < str.length(); i++, j++) { // Notice the 2 loops , we have to fill upper triangle
                                                                 // of 2-D array in a diagnal way..see video
                                                                 // and cond. for for lopp shold (j<len), NOT (i<len)

                // main diagnal of the 2D array will represent 1 charcter hence will be
                // pallendrome
                if (i == j) { // you can also write if(gap==0)
                    dp[i][j] = 1;
                }
                // diagonal just uppoer to main diagnal will be 2 character long
                // and if both chracters are same they will be pallendome

                else if (i + 1 == j) { // you can also write if(gap==1)
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = 1;
                    }
                }
                // for other cases- if left most and right most character is same than
                // move 1 charcter from left and 1 chacter from right and checkF if they are
                // pallendrome
                // (checking if the value is 1)
                else {

                    int x1 = str.charAt(i);
                    int x2 = str.charAt(j);
                    if (x1 == x2 && dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    }

                }

                // keep setting the latest value...the last value will be the answer
                if (dp[i][j] == 1) {
                    ans = str.substring(i, j + 1);
                }
            }

        }
        return ans;
        // // printing
        // for (int i = 0; i < str.length(); i++) {
        // for (int j = 0; j < str.length(); j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }
    }

    public static void main(String[] args) {
        String str = "abkccbe";
        str = "abba";

        String result = cprint_Longest_Pallndromic_SubString(str);
        System.out.println(result);
    }

}
