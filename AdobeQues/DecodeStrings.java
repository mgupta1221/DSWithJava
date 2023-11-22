package AdobeQues;

import java.util.Stack;

//Adobe Asked question
// Problem: https://www.geeksforgeeks.org/decode-string-recursively-encoded-count-followed-substring/

// Solved with 2 approaches - using 1 stack and 2 stacks

public class DecodeStrings {

    // Aproach 1: Using 2 stacks
    static String decodedString1(String s) {

        Stack<String> st = new Stack<>(); // to store the string already calculated so far
        Stack<Integer> nums = new Stack<>(); // to store all numbers ocurring before opening bracket and use them later
                                             // in calc
        StringBuilder sb = new StringBuilder(); // to maintain the current string between [ and ]

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            if (ch == ']') {
                String str = sb.toString(); // ca
                String stItem = st.pop();// b
                int k = nums.pop();
                StringBuilder tempStr = new StringBuilder();
                for (int j = 1; j <= k; j++) {
                    tempStr.append(str);
                }
                stItem += tempStr;
                sb = new StringBuilder();
                sb.append(stItem);

            } else if (ch == '[') {
                st.push(sb.toString());
                sb = new StringBuilder();
            }

            else if (Character.isDigit(ch)) {
                int num = ch - '0';
                while (i + 1 <= s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                nums.push(num);
            } else {
                sb.append(ch);
            }

        }
        return sb.toString();

    }

    // Approach 2 - Using 1 stack
    static String decodedString2(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            if (ch != ']') {
                st.push(ch);
            } else {

                StringBuilder sb = new StringBuilder();
                while (st.peek() != '[') {
                    Character c = st.pop();
                    sb.insert(0, c); // insert at front
                }

                st.pop(); // removing '['

                // get the number
                int n1 = 0;
                int count = 1;
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    int num = st.pop() - '0';

                    n1 = num * count + n1;
                    count *= 10;
                }

                // THIS IS IMPORTANT:  put back the substring in stack k times
                while (n1 > 0) {
                    for (int j = 0; j <= sb.length() - 1; j++) {
                        st.push(sb.charAt(j));
                    }
                    n1--;
                }

            }
        }
        char[] result = new char[st.size()];
        for (int i = st.size() - 1; i >= 0; i--)
            result[i] = st.pop();
        return new String(result);

    }

    public static void main(String[] args) {
        // String str = "3[b2[ca]]";
        String str = "3[a]2[bc]";
        // String result = decodedString1(str);

        String result = decodedString2(str);

        System.out.println(result);
    }

}
