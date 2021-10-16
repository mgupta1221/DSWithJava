package RecursionAndBacktracking.RecursionOnWayUp;

// Question: https://www.youtube.com/watch?v=K5xJXbnYMBc

// Solution: https://www.youtube.com/watch?v=sPAT_DbvDj0

//For "abc"
//Expected Output  : "abc", "acb","bac" , "bca", "cab", "cba"  

public class PrintPermutation {
    public static void main(String[] args) {

        String str = "abcd";
        printPermution(str, "");

    }

    public static void printPermution(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // abc
        for (int i = 0; i < str.length(); i++) { // looping to pick each character 'a', 'b' and 'c' each time to get
                                                 // permutations
            char firstChar = str.charAt(i); // a
            String restOfString = str.substring(0, i) + str.substring(i + 1); // bc
            printPermution(restOfString, ans + firstChar);   //this will give "abc" and "acb"
        }

    }

}
