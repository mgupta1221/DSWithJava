package AdobeQues;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {

    // Problem: https://www.geeksforgeeks.org/leaders-in-an-array/
    // An element is a leader if it is greater than all the elements to its right side. And the rightmost element is always a leader. 

    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int max = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                result.add(max);
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 16, 17, 4, 3, 5, 2 };
        ArrayList<Integer> result = leaders(A, A.length);

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
