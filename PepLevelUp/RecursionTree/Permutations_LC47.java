package PepLevelUp.RecursionTree;

import java.util.ArrayList;
import java.util.List;

public class Permutations_LC47 {
    // Appraoch 1: For loop approach
    public static int permute(int[] arr,
            int idx,
            List<List<Integer>> ans, List<Integer> smallAns) {

        if (idx == arr.length) {
            // ans.add(new ArrayList<>(smallAns));
            List<Integer> tempResult = new ArrayList<>(smallAns);
            ans.add(tempResult);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -99) {
                int tempItem = arr[i];
                arr[i] = -99;
                smallAns.add(tempItem);
                count += permute(arr, idx + 1, ans, smallAns);
                arr[i] = tempItem;
                smallAns.remove(smallAns.size() - 1);
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2 };
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        int result = permute(arr, 0, ans, smallAns);
        for (List<Integer> a : ans) {
            for (Integer b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }
}
