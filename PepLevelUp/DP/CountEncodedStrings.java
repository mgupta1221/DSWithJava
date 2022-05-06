package PepLevelUp.DP;

public class CountEncodedStrings {

    // Question:
    // https://nados.io/question/count-encodings
    // For 123 -> there are 3 encodings. abc, aw, lc
    // For 993 -> there is 1 encoding. iic
    // For 013 -> This is an invalid input. A string starting with 0 will not be
    // passed.

    // Solution :
    // https://www.youtube.com/watch?v=jFZmBQ569So&list=TLGG1LB41VKgJEkwNTA1MjAyMg
    // Assinging meaning to DP array :
    // We will store the results in an dp array, let's say dp. Now dp[i] will store
    // the number of encodings possible till the i-th char. This is our meaning

    // Trick Diagram: CountEncodedStrings.png
    // For 2310 where (i-1) is 1..... i is 0 .... (i-2) is 3
    // this can be split into 231-0 and 23-10
    // 231-0 means 0 possibilities becuase 0 does not have encoding
    // 23-10 means 10 (J) can be appended to dp[i-2]
    private static int CountEncodedStrings_Tab(String str) {
        // creating 1D array
        int[] dp = new int[str.length()];

        dp[0] = 1; // 1 charcter se ek hi encoding ban sakti hai

        // hum loop 1 se shuru karenge kyunki 0 pehle hi assign hai
        // hum hamesha last ke 2 charcters(i-1 and i) ko consider karenge kyunki maximum
        // encoding
        // 26 ki ho sakti hai
        // i.e. for A to Z it can be 26 at max.
        // 2 charcters mai 4 possibility hongi :
        // {0,0} {0, non zero} {non zero , 0} and{non zero, non zero}
        /// uske hum neeche cases bana lenge or inke basis pe dp ko fill karenge
        for (int i = 1; i < dp.length; i++) {
            char char1 = str.charAt(i - 1); // char at i-1
            char char2 = str.charAt(i); // char at i
            if (char1 == '0' && char2 == '0') {
                // e.g. 21100 , here 'i-1' index will be first 0 and i will second zero
                // Since 0 is not any valid alphabet so we cnnot append anything
                dp[i] = 0;
            }
            if (char1 == '0' && char2 != '0') {
                // E.g. 21103 can be split as 211-03 and 2110-3
                // as told earlier here 'i-1' will be first 0 and 'i' will be 3
                // 211-03 can not be solved becuase 03 is nothing in alphabets
                // 2110-3 ...this is possible becuase we will append 3 after all the possible
                // answers for "2110"
                dp[i] = dp[i - 1];
            }
            if (char1 != '0' && char2 == '0') {
                if (char1 == '1' || char1 == '2') { // can be 10 or 20 only
                    // E.g. 21120 can be split as 211-20 and 2112-0
                    // 211-20 ki call lag sakti hai 211 ke answers ke aage 20(T) append kar ke
                    // 2112-0 ...0 ki call nahi lag sakti

                    dp[i] = i >= 2 ? dp[i - 2] : 1; // we put this ternary because i-2 ki value -1 ho jayegi jab i=1
                                                    // hoga
                    // : 1 at the end becuase i will be 1 (i <= 1), see example below
                    // i= 1 means the number is 2 characters long and we are solving 2nd character
                    // e.g. 20 so it will be one value only i.e. T
                } else {
                    dp[i] = 0;// agar 26 se bada hai to koi value nahi ban sakti
                }
            } else {
                String subStr = str.substring(i - 1, i + 1); // getting the 2 chars in string
                if (Integer.parseInt(subStr) <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);// E.g. 3723 , now possibilities will be 37-23 and
                                                                 // 323-3
                                                                 // For 37-23 , 23 i.e 'w' will be appended all //
                                                                 // charcters of 37 (i-2 case)
                                                                 // For 372-3 , 3 i.e 'c' will be appended all charcters
                                                                 // of 372 (i-1 case)
                } else {
                    dp[i] = dp[i - 1]; // E.g. 3783...3 wali call to lag jati (i-1)
                                       // but 83 wali call (i-2) nahi lagti
                }
            }

        }

        return dp[str.length() - 1];

    }

    public static void main(String[] args) {

        String str = "21123"; // answer should be 8

        int result = CountEncodedStrings_Tab(str);
        System.out.println(result);

    }
}
