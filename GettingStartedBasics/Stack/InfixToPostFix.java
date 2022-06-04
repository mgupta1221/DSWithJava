package GettingStartedBasics.Stack;

import java.util.Stack;

// Quesiton: Solve 2 + (5 - 3 * 6 / 2 ) -- this is Infix

//Tip: See the video for Infix Evaluation, logic is exactly same

// Solution video :
// https://www.youtube.com/watch?v=f29emeUcw6c&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=18
public class InfixToPostFix {

    private static int InfixToPostfix(String str) {

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
            // Case 3
            else if (ch == ')') {
                while (operands.peek() != '(') {
                    Character operator = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    int resultCalc = val1 + val2 + operator; // This line is differnce
                    operands.push(resultCalc);

                }
                operators.pop();
            }

            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // ch wants higher priorty operators to solve first
                if (operators.size() > 0 && operators.peek() != '(' &&
                        precedence(ch) <= precedence(operators.peek())) {
                    Character operator = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    int resultCalc = val1 + val2 + operator;
                    ;
                    operands.push(resultCalc);
                }
                // ch will push itself now
                operators.push(ch);
            }

        }
        // This is IMPORTANT, kabhi bhi last mai operators bach jate hain isliye ek bar
        // fir wahi loop chala denge
        while (operators.size() > 0) {
            Character operator = operators.pop();
            int val2 = operands.pop();
            int val1 = operands.pop();
            int resultCalc = val1 + val2 + operator;
            operands.push(resultCalc);
        }
        return operands.peek();

    }

    // This is helper to calculcator result of an operation
    private static int calc(int val1, int val2, Character operator) {
        if (operator == '+') {
            return val1 + val2;
        }
        if (operator == '-') {
            return val1 - val2;
        }
        if (operator == '/') {
            return val1 / val2;
        } else {
            return val1 * val2;
        }

    }

    // This is another helper to get the precendence of operators
    // e.g. '*' has more precendence than '+' and '-'
    private static int precedence(Character ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*') {
            return 2;
        }

        return 2; // ch == '/'

    }

    public static void main(String[] args) {
        String str = "2+5*6/3";
        int result = InfixSolver(str);
        System.out.println("Result is : " + result);
    }

}
