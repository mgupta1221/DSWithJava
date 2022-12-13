package GettingStartedBasics.Stack;

import java.util.Stack;

// Input:
// MATRIX = { {0, 0, 1, 0},
//            {0, 0, 1, 0},
//            {0, 0, 0, 0},
//            {0, 0, 1, 0} }
// Output:id = 2
// Explanation: The person with ID 2 does not 
// know anyone but everyone knows him

// Solution video: https://www.youtube.com/watch?v=CiiXBvrX-5A&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=20

// Aproach uses Elimination technique:
// First we put all elements in stack and pick top 2 elements from stack and check if one knows other.
// If first knows second than second can be a celebrity and vice versa. We do this till stack has 2 elemnts
// At last, check if the last element in stack suffices the celebrity condition with other elements.

public class CelebrityProblem {

    // static int MATRIX[][] = {
    // { 1, 0, 1 },
    // { 1, 1, 0 },
    // { 0, 1, 1 }
    // };
    static int MATRIX[][] = {
            { 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 }
    };

    private static boolean knows(int a, int b) {
        if (MATRIX[a][b] == 1)
            return true;
        else
            return false;

    }

    private static int findCelebrity(int n) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();

            // if a knows b, than a cannot be celebrity but b can be celebrity
            if (knows(a, b)) {
                st.push(b);
            } else {
                st.push(a);
            }
        }

        // Last step: Check if the last person is celebrity or not
        int c = st.peek();
        // If any person doesn't know 'c' than return -1

        // NOTICE the condition is written to return -1 and NOT 'c'.
        // If condition does not suffice than return 'c' at the end.
        for (int i = 0; i < n; i++) {
            if (i != c && (knows(c, i) ||
                    !knows(i, c)))
                return -1;
        }
        return c;

    }

    public static void main(String[] args) {
        int n = MATRIX[0].length; // getting length of matrix;

        int result = findCelebrity(n);
        System.out.println(result);
    }

}
