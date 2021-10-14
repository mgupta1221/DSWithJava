package RecursionAndBacktracking.RecursionWithArrays;

public class DisplayArray {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9 };

        DisplayArray(arr, 0);

    }

    // Expectation: idx se end tak sab print kar de
    // Faith : idx+1 se end tak print karna janta h
    public static void DisplayArray(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }

        System.out.println(arr[idx]);
        DisplayArray(arr, idx + 1); // recursive call

        // System.out.println(arr[idx]);// Print here to print in reverse

    }

}
