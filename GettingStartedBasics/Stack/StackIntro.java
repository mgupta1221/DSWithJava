package GettingStartedBasics.Stack;

import java.util.*;

public class StackIntro {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        System.out.println(st);// Printing stack
        System.out.println("Current Stack size" + st.size()); // getting stack size

        System.out.println("Stack peek: " + st.peek());// Peek will give the top most element without 'removing'
        System.out.println("New Stack size after peek is : " + st.size());

        int element = st.pop(); // this will remove the most recent item added
        System.out.println("Item popped is: " + element + " .New stack size after pop is: " + st.size());
    }
}
