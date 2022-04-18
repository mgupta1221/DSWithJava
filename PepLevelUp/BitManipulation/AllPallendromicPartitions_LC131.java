
package PepLevelUp.BitManipulation;

import java.util.ArrayList;
import java.util.List;

//See Euler diagram in Notes.doc
public class AllPallendromicPartitions_LC131 {

    // Helper function to check pallendrome
    private static boolean isPallendrome(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partitionHelper(s, 0, list, ans);
        return ans;

    }

    // recurive function
    public static void partitionHelper(String str, int index, List<String> list, List<List<String>> ans) {
        if (index == str.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < str.length(); i++) {
            if (isPallendrome(str, index, i)) { // means going from 'index' till current 'i'
                // which will keep increasing
                list.add(str.substring(index, i + 1)); // adding if pallendrome
                partitionHelper(str, index + 1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> result = partition("aab");
        for (List<String> l1 : result) {
            for (String n : l1) {
                System.out.print(n + " ");
            }

            System.out.println();
        }

    }

}