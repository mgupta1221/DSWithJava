package RecursionAndBacktracking.RecursionOnWayUp;

// This question is similar to GetStairPaths in "Recursion With ArraysLists" section
// there we were returning the values using ArrayList but here we have to print them

// Key is that we have taken an extra parameter in the function called 'path' to calculate the path in 
// each iteration and printing it at Base Condition 

// Question: https://www.youtube.com/watch?v=JxIoGHzzoW8
// Solution: https://www.youtube.com/watch?v=NEuYcztalew

public class PrintStairPaths {
    public static void main(String[] args) {
        int n = 4;
        printSP(n, "");

    }

    public static void printSP(int n, String path) {

        if (n == 0) {
            System.out.println(path);
            return;
        } else if (n < 0) {
            return;
        }

        printSP(n - 1, path + "1");
        printSP(n - 2, path + "2");
        printSP(n - 3, path + "3");
    }

}
