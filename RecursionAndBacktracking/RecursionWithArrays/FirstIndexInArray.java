package RecursionAndBacktracking.RecursionWithArrays;

// https://www.youtube.com/watch?v=TU0xUG9eO3Y

public class FirstIndexInArray {
    public static void main(String[] args) {
        int[] arr = { 2, 10, 6, 9, 8, 3, 2, 6, 2, 4 };
        int num = 4;
        int index = FirstIndex(arr, 0, num);
        System.out.println("Index is: " + index);
    }

    public static int FirstIndex(int[] arr, int idx, int num) {
        // base condition
        if (idx == arr.length) {
            return -1;

        }
        if (num == arr[idx]) {
            return idx;
        }

        return FirstIndex(arr, idx + 1, num);
    }

}
