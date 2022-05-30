package GettingStartedBasics.Stack;

import java.util.Stack;
// Question
// 1. You are given a string exp representing an expression.
// 2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
// 3. But, some of the pair of brackets maybe extra/needless. 
// 4. You are required to print true if you detect extra brackets and false otherwise.

// e.g.
// ((a + b) + (c + d)) -> false
//  (a + b) + ((c + d)) -> true

public class DuplicateParenthesis {
    public static boolean haveDuplicateParenthesis(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If next string element is closing bracket ')' during string traversal, then:
            // -> Check if last inserted element in the stack was opening bracket '(',
            // that means there is duplicacy so return 'true'
            // -> Else, keeping popping elements (till you find opening bracket and remove
            // it
            // too)
            // If next String element is NOT closing bracket , keep pushing to the stack
            if ((!st.isEmpty()) && (c == ')')) {
                // if element on the top is '('
                if (st.peek() == '(') {
                    return true; // 'true' means has duplcate parenthesis
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }

            } else {
                // Keep pushing if element is not a closing bracket
                st.push(c);
            }

        }
        return false;
    }

    public static void main(String[] args) {
       // String s1 = "(a + b) + ((c + d))"; // -> true..mean have duplicate parentheseis
        String s1 = "((a + b) + (c + d))"; // -> false..mean NO duplicate parentheseis

        Boolean result = haveDuplicateParenthesis(s1);
        System.out.println(result);
    }
}
