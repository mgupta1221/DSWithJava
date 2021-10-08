package GettingStartedBasics.FunctionsAndArrays;

import java.util.Scanner;

// Check readme in folder
// https://www.youtube.com/watch?v=iKSI_9NHR1M

// Method 1
//Solution Desription - Here the number of subsets can be 2^, so we run the initial loop 
//till 8(assuming the number of charcters are 3)

// Next we take the binary approach , like 000, 001, 010, 011...111
// So we run inner loop from 0 to 2(if charcters input are 3)
// We keep dividing i(from first loop) and whenever the remainder is 0, we print space or hyphen(-)
// if remainder encountered is 1, then we print arr[j] (charcter from input say a, or b ,or c)

public class SubsetsOfArray {
    // Method 1
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int numberOfElements = scn.nextInt();
        int[] arr = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            arr[i] = scn.nextInt();
        }

        int rem = 0;

        // For 3 items, results will 2^3 = 8
        int totalItems = (int) Math.pow(2, arr.length);

        for (int i = 0; i < totalItems; i++) { // 0 1 2 3 4 5 6 7
            int temp = i;
            String set = "";

            for (int j = 0; j < arr.length; j++) { // 0 1 2
                rem = temp % 2;
                temp = temp / 2;

                if (rem == 0) {
                    set = set + "-";
                } else {
                    set = set + arr[j];
                }

            }
            System.out.println(set);

        }
    }

}
