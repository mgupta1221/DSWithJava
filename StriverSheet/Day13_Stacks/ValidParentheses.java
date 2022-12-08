package StriverSheet.Day13_Stacks;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (st.size() != 0 && (Math.abs(ch - st.peek()) <= 2)) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        if (st.size() == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        String str = "()))";
        boolean result = isValid(str);
        System.out.println(result);

    }

}
