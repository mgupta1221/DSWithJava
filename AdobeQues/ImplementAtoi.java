package AdobeQues;

// Problem:
// https://practice.geeksforgeeks.org/problems/implement-atoi/1
// New

//Appraoch: First run a loop and check if first charcter is '-' then preserve this info to return a negative number at the end as ouput
// In other iterations, check if digit is numerical or not using (ch-'0') and form the number as at line number 26

public class ImplementAtoi {

    public static int atoi(String str) {
        int result = 0;
        boolean isNegative = false;
        for (int i = 0; i <= str.length() - 1; i++) {
            if (i == 0 && str.charAt(0) == '-') {
                isNegative = true;
                continue;

            }

            Character ch = str.charAt(i);
            if (ch - '0' < 0 || ch - '0' > 9) {
                result = -1;
                return result;
            } else {
                int num = (ch - '0');
                result = num + result * 10;
            }
        }
        return isNegative ? result * -1 : result;
    }

    public static void main(String[] args) {
        String str = "703";
        int result = atoi(str);
        System.out.println(result);
    }
}
