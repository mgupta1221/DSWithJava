package Strings;

public class StringCompression {

    // Quesiton and Solution: : https://www.youtube.com/watch?v=6W1MDK7nPZs

    // Input : aaabbcccddaeef
    // Output: a3b2c3d2ae2f

    public static void main(String[] args) {

        String str = "aaabbcccddaeef";
        int len = str.length();
        int ct = 1;
        char ch = str.charAt(ct);
        String outputString = ch + "";
        int tempCount = 1;
        while (ct < len) {

            char currentChar = str.charAt(ct);
            if (ch == currentChar) {
                tempCount++;
            } else {
                if (tempCount > 1) {// if count 1 than number is not required
                    outputString += tempCount;
                }
                ch = currentChar;
                tempCount = 1;
                outputString += currentChar;
            }
            ct++;

        }
        System.out.println("Result: " + outputString);

    }

}
