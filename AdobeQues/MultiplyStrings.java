package AdobeQues;

// Problem: https://www.geeksforgeeks.org/multiply-large-numbers-represented-as-strings/

// Approach: We keep one integer array for result. The max result of the answer can be s1.length+s2.length hence the array
//  is of this size. For negative number, we checked first character of each string and trim that character to use the 
// number values for computation.
// We maintian i1 and i2 to move from one digit to the other and keep storing result in result[i1+i2] 
// and i1 takes care to move 1 digit to the right after each s2's digits multiplication

public class MultiplyStrings {

    public static String multiplyStrings(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] result = new int[l1 + l2];

        // Edge cases
        if (l1 == 0 || l2 == 0)
            return "0";

        if (s1.equals("0") || s2.equals("0"))
            return "0";

        // To handle negative inputs
        Boolean neg = false;
        if (s1.charAt(0) == '-' && s2.charAt(0) == '-') {
            neg = false;
            s1 = s1.substring(1);
            s2 = s2.substring(1);
        }
        if (s1.charAt(0) == '-' && s2.charAt(0) != '-') {
            neg = true;
            s1 = s1.substring(1);
        }
        if (s1.charAt(0) != '-' && s2.charAt(0) == '-') {
            neg = true;
            s2 = s2.substring(1);
        }

        // main logic
        int i1 = 0;
        int i2 = 0;

        for (int i = s1.length() - 1; i >= 0; i--) {
            int n1 = s1.charAt(i) - '0';// getting number from string
            int carry = 0;

            i2 = 0;// reset i2 to 0 after each s2's digit multiplication
            for (int j = s2.length() - 1; j >= 0; j--) {
                int n2 = s2.charAt(j) - '0';

                /// Multiply with current digits of s1 and s2 and add result to previously
                /// stored result[] at current position
                int product = n1 * n2 + result[i1 + i2] + carry;
                carry = product / 10;
                result[i1 + i2] = product % 10; // update result with new value

                i2++;
            }

            // handle pending carry
            if (carry > 0) {
                result[i1 + i2] += carry;
            }
            i1++;

        }

        // result is filled from left to right (0 to n-1) so there might be empty zeroes
        // at the end, trim them
        // E.g. s1= 15 , s2= 2
        // result = 030 that means ending 0 of result 30 will be at 0th index
        // of result[] array, so last zeroes should be ignored
        int n = result.length - 1;
        while (n >= 0 && result[n] == 0) {
            n--;
        }

        // convert result[] array to string
        String res = "";
        while (n >= 0) {
            res += result[n--];
        }
        // add negative if required
        if (neg == true) {
            res = "-" + res;
        }
        return res;
    }

    public static void main(String[] args) {
        // String s1 = "33";
        // String s2 = "44";
        String s1 = "-9";
        String s2 = "02";
        String result = multiplyStrings(s1, s2);
        System.out.println(result);
    }
}
