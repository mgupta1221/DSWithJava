package StriverSheet.Day15_Strings;

public class String_to_Integer_atoi {

    public static int myAtoi(String s) {
        long result = 0;
        int operator = 1;

        if (s.length() == 0)
            return 0;
        int i = 0;
        // remove leading spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // if string is empty, return 0
        if (i == s.length()) {
            return 0;
        }

        // Keep a note if value is positive or negative, default is '+'
        if (s.charAt(i) == '+') {
            operator = 1;
            i++;
        } else if (s.charAt(i) == '-') {
            operator = -1;
            i++;
        }

        // Now iterate the characters
        while (i < s.length()) {
            int digit = s.charAt(i) - '0';
            // If digit is other than number than break out of loop
            if (digit < 0 || digit > 9)
                break;

            // keep creating result
            result = result * 10 + digit;

            // checking overflow
            if (result > Integer.MAX_VALUE) {
                return operator == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }

        result = result * operator;
        return (int) result;

    }

    public static void main(String[] args) {
        /// int a = myAtoi("");
        // int a = myAtoi(" ");
        // int a = myAtoi("-91283472332");
        // int a = myAtoi("3.1345");
        // int a = myAtoi("+-42");
        // int a = myAtoi(" +0 123");
        // int a = myAtoi("20000000000000000000");
        // int a = myAtoi(" +10");
        // int a = myAtoi("2147483648");
        int a = myAtoi("2147483646");
        System.out.println(a);
    }
}
