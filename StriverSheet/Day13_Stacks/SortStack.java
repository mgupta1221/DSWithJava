package StriverSheet.Day13_Stacks;

import java.util.Stack;

// Aproach recursion 

// Create a stack and push all the elements in it.
// Call sortStack(), which will pop an element from the stack and pass the popped element to function sortInserted(), then it will keep calling itself until the stack is empty.
// Whenever sortInserted() is called it will insert the passed element in stack in sorted order.
// Print the stack     
public class SortStack {

    public static void sortStack(Stack<Integer> st) {
        if (st.empty())
            return;
        int item = st.pop();
        sortStack(st);
        sortInserted(st, item);

    }

    public static void sortInserted(Stack<Integer> st, int item) {
        if (st.empty() || st.peek() < item) {
            st.push(item);
            return;
        }
        int poppedItem = st.pop();
        sortInserted(st, item);
        st.push(poppedItem);

    }

    public static void printStack(Stack<Integer> st) {
        Object[] arr = st.toArray();
        for (int j = 0; j < arr.length; j++)
            System.out.print(arr[j] + " ");
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.print(
                "Stack elements before sorting: -> ");
        printStack(s);

        sortStack(s);

        System.out.print(
                " \n\nStack elements after sorting: -> ");
        printStack(s);
    }
}
