package GettingStartedBasics.Stack;

import java.util.Stack;

// Quesiton: Solve 2 + (5 - 3 * 6 / 2 )

// Solution video :
// https://www.youtube.com/watch?v=IY0nZLEg6MA&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=16
public class InfixEvalaution {

    private static int InfixSolver(String str) {

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            // Case 1
            if (ch == '(') { // pening bracket will be pushed, no operation required
                operators.push(ch);
            }
            // Case 2
            else if (Character.isDigit(ch)) { // directly push to stack if integer
                operands.push(ch - '0');// notice how we are converting string to Integer
            }
            // Case 3
            else if (ch == ')') {
                while (operators.peek() != '(') {// solve values till we find opening bracket in operator stack
                    Character operator = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    int resultCalc = calc(val1, val2, operator);
                    operands.push(resultCalc);// pushing the result back to stack

                }
                operators.pop();// opening bracket ko pop kiya
            }
            // Case 4
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // ch wants higher priorty operators to solve first
                if (operators.size() > 0 && operators.peek() != '(' &&
                        precedence(ch) <= precedence(operators.peek())) { // last character on operator stack
                    Character operator = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    int resultCalc = calc(val1, val2, operator);
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
            int resultCalc = calc(val1, val2, operator);
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
        String str = "2+5+(6/3)";
        int result = InfixSolver(str);
        System.out.println("Result is : " + result);
    }

}
