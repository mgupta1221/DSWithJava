package RecursionAndBacktracking.RecursionOnWayUp;

// https://nados.pepcoding.com/content/0/d8960ab6-d8d3-4048-9dc7-a8a1e3925db5/

// Question: https://www.youtube.com/watch?v=jUo0Qis4FKU
// Solution: https://www.youtube.com/watch?v=2ClSccwnq1Y

// 1->a
// 2->b
// 3->c
// .
// .
// .
// 26-> z

// Q:  : 123
//Ans: Print all combinations :    abc, aw, lc

// Q:  : 103
//Ans: Print all combinations :    jc

//Q: 303
//Ans: No Output possible


//Solution Logic: Here we take first chracter and then work on rest of the string
//and then we take first 2 characters(maximum is 26 for 'Z') and work on rest of the string

public class PrintEncodings {
    public static void main(String[] args) {

        String str = "123";
        printAllEncodings(str, "");

    }

    public static void printAllEncodings(String str, String ans) {
        // if length=0, then print answer
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // if length=1, then simply add the character to last answer and print
        if (str.length() == 1) {
            char ch = str.charAt(0);
            if (ch == '0') {
                return;
            } else {
                // Converting digit to  alphabet. Digit is in String format i.e. Converting '3'
                // to 'c'

                int charVal = ch - '0'; /// first converting character to number
                char code = (char) ('a' + charVal - 1); // notice we are typecasting and adding as well

                ans = ans + code; // adding the character to last answer and printing
                System.out.println(ans);
            }
        } else { // if length > 1, so here we handle for [1, 23] and then [12, 3]
            // For [1, 23]
            char ch = str.charAt(0);
            String ros = str.substring(1);

            if (ch == '0') {
                return;
            } else {
                int charVal = ch - '0';
                char code = (char) ('a' + charVal - 1);
                printAllEncodings(ros, ans + code); // here we will recurse to handle rest part of the string

            }

            // For [12, 3]
            String ch2 = str.substring(0, 2);
            String ros2 = str.substring(2);

            int charVal2 = Integer.parseInt(ch2);
            if (charVal2 <= 26) {
                char code = (char) ('a' + charVal2 - 1);
                printAllEncodings(ros2, ans + code);
            }

        }
    }

}
