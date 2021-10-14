package RecursionAndBacktracking.RecursionWithArrays;

// https://www.youtube.com/watch?v=xttMLI4Kb3k

public class LastIndexInArray {
    public static void main(String[] args) {
        int[] arr = { 2, 10, 6, 9, 8, 3, 2, 6, 2, 4 };
        int num = 4;
        int index = LastIndex(arr, 0, num);
        System.out.println("Index is: " + index);

    }

    public static int LastIndex(int[] arr, int idx, int num) {
        // base condition
        if (idx == arr.length) {
            return -1;
        }

        int result = LastIndex(arr, idx + 1, num);

        // yahan pe hum wapas laut rhe hain(last to first element in recursion) becuase
        // below code is after the recursive call.

        // say these are indexes of the array like [0,1,2,3,4,5]
        // Now we are saying ki - if we are  coming from last till 2nd index(1) if we get -1 which 
        // means we did not find the element from last index till 2nd index than we will check 
        // for element existence at reminaing 0th index
        // else we will return result as is.
        if (result == -1) {
            if (arr[idx] == num) {
                return idx;
            } else {
                return -1;
            }

        } else {
            return result;
        }

    }

}
