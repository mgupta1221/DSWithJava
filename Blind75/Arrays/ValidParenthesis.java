package Blind75.Arrays;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;
                Character top = stack.peek();
                if (ch == ')' && top == '(')
                    stack.pop();
                else if (ch == '}' && top == '{')
                    stack.pop();
                else if (ch == ']' && top == '[')
                    stack.pop();
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "([()))";
        boolean result = isValid(str);
        System.out.println(result);
    }
}
