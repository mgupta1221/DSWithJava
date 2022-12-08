package StriverSheet.Day13_Stacks;

class StackCustom {

    int arr[];
    int top = -1;

    public StackCustom(int size) {
        arr = new int[size];
    }

    public void push(int val) {
        if (top != arr.length - 1) {
            top++;
            arr[top] = val;
        } else {
            System.out.println("Stack is full");
        }
    }

    public int pop() {
        if (top != -1) {
            int deletedItem = arr[top];
            top--;
            return deletedItem;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public int peek() {
        if (top != 0) {
            return arr[top];
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }
}

public class StackUsingArray {

    public static void main(String[] args) {
        StackCustom stack = new StackCustom(3);
        int deletedItem = stack.pop();
        System.out.println("Deleted item: " + deletedItem);
        System.out.println("=================");
        stack.push(10);
        stack.push(30);
        stack.push(50);
        stack.push(40);
        System.out.println("=================");
        deletedItem = stack.pop();
        System.out.println("Deleted item: " + deletedItem);

        deletedItem = stack.pop();
        System.out.println("Deleted item: " + deletedItem);
        deletedItem = stack.pop();
        System.out.println("Deleted item: " + deletedItem);
        stack.pop();

        System.out.println("=================");

    }

}
