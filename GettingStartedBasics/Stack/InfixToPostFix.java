package GettingStartedBasics.Stack;

import java.util.Stack;

// Quesiton: Solve 2 + (5 - 3 * 6 / 2 ) -- this is Infix

//Tip: See the video for Infix Evaluation, logic is exactly same

// Solution video :
// https://www.youtube.com/watch?v=f29emeUcw6c&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=18
public class InfixToPostFix {

    private static String InfixToPostfix(String str) {

        Stack<String> postFix = new Stack<>();
        Stack<Character> operators = new Stack<>();


        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            }

            else if ((ch >= '0' && ch <= '9') ||
                    ch >= 'a' && ch <= 'z' ||
                    ch >= 'A' && ch <= 'Z') {
                postFix.push(ch + ""); // adding "" to convert character to String
            }
            
            else if (ch == ')') {
                while (operators.peek() != '(') {
                    process(postFix, operators);
                }
                operators.pop();
            }

            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                // ch wants higher priorty operators to solve first
                if (operators.size() > 0 && operators.peek() != '(' &&
                        precedence(ch) <= precedence(operators.peek())) {
                    process(postFix, operators);
                }
                // ch will push itself now
                operators.push(ch);
            }

        }
        // This is IMPORTANT, kabhi bhi last mai operators bach jate hain isliye ek bar
        // fir wahi loop chala denge
        while (operators.size() > 0) {
            process(postFix, operators);
        }
        return postFix.peek();
    }

    private static void process(Stack<String> postFix, Stack<Character> operators) {
        Character operator = operators.pop();
        String val2 = postFix.pop();
        String val1 = postFix.pop();
        String resultCalc = val1 + val2 + operator; // This line is different from Infix evalauation solution
        postFix.push(resultCalc);
    }

    // This is another helper to get the precendence of operators
    // e.g. '*' has more precendence than '+' and '-'
    private static int precedence(Character ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 3; // for ^
        }

    }

    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        String result = InfixToPostfix(str);
        System.out.println("Result is : " + result);
    }

}
