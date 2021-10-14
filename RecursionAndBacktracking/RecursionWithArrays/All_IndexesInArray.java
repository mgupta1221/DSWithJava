package RecursionAndBacktracking.RecursionWithArrays;

//Problem: https://www.youtube.com/watch?v=TYIZmI5FesU
// Solution: https://www.youtube.com/watch?v=bQkwHBaNioE

public class All_IndexesInArray {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 9, 8, 3, 2, 6, 2, 3 };
        int num = 3;
        int[] resultIndexes = AllIndexes(arr, 0, num, 0);
        for (int i = 0; i < resultIndexes.length; i++) {
            System.out.print(resultIndexes[i] + "\t");
        }

    }

    // Solution logic
    // 1) jaate waqt count kar lenge kitni bar 'num' mila
    // 2) Base Case mai utne count ke aray bana lenge
    // 3) Lautte hue us array ko fill kar lenge

    public static int[] AllIndexes(int[] arr, int idx, int num, int foundSoFar) {
        // Approach 1 to write code

        if (idx == arr.length) {
            int[] result = new int[foundSoFar];// Step 2: Base Case mai utne count ke
            // array bana lenge since we have
            // we reached the end of aray here
            return result;

        }
        if (arr[idx] == num) {
            foundSoFar++; // Step 1: jaate waqt count kar lenge kitni bar 'num' mila
        }

        int[] result = AllIndexes(arr, idx + 1, num, foundSoFar);

        if (arr[idx] == num) {
            System.out.println(arr[idx] + " " + idx + " " + foundSoFar);

            result[--foundSoFar] = idx; // Step 3: Lautte hue us array ko fill kar lenge
            // Notice we are reducing "--" foundSoFar to fill values
        }

        return result;

        // Approach 2 to write same code

        // if (idx == arr.length) {
        // int[] result = new int[foundSoFar];// Step 2: Base Case mai utne count ke
        // aray bana lenge since we have
        // // reached the end of aray here
        // return result;

        // }
        // if (arr[idx] == num) {
        // int[] result = AllIndexes(arr, idx + 1, num, foundSoFar + 1); // Step 1:
        // jaate waqt count kar lenge kitni
        // // bar 'num' mila
        // result[foundSoFar] = idx; // Step 3: Lautte hue us array ko fill kar lenge
        // return result;

        // } else {
        // int[] result = AllIndexes(arr, idx + 1, num, foundSoFar);
        // return result;
        // }

    }

}
