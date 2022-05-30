package GettingStartedBasics.Stack;

import java.util.Stack;

// Leetcode 20:
// https://leetcode.com/problems/valid-parentheses/



//Pepcoding solution:

// Our approach: Till the time it is an opening bracket, keep pushing to the stack.
// When a closing bracket comes -  than check the last inserted element in stack(via peek method).
// Now the technique is CLosing and ending bracket's ASCII differnce is <=2 , ... so if 
// we find the differnece between current closing bracket and last inserted bracket is <=2 than pop
// Complete the loop, if the stack is empty at the end of the loop, there are no duplicate brackets

// Ascii difference between :
// '(' and ')' = 1
// '{' and '}' = 2
// '[' and ']' = 2

// Trick Diagram: "ParenthesisASCII.png"

public class ValidParenthesis {
    public static boolean isValidParenthesis(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If first element of the string is a closing bracket, than return false
            // If stack is empty and new element comes is a closing bracket than also return
            // false
            if ((i == 0 || st.isEmpty()) && (c == ')' || c == '}' || c == ']')) {
                return false;
            }

            if ((!st.isEmpty()) && (c == ')' || c == '}' || c == ']')) {
                if (Math.abs(s.charAt(i) - st.peek()) <= 2) {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                // Keep pushing if element is an opening bracket
                st.push(c);
            }

        }

        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "()))";
        Boolean result = isValidParenthesis(s);
        System.out.println(result);
    }
}
