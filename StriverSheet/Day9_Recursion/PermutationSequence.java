package StriverSheet.Day9_Recursion;

import java.util.ArrayList;

public class PermutationSequence {

    // LC 60 : https://leetcode.com/problems/permutation-sequence/

    // Check the bruteforce solution on the below link and see how time complexity
    // is calculated
    // https://takeuforward.org/data-structure/find-k-th-permutation-sequence/

    // Brute Force: The extreme naive solution is to generate all the possible
    // permutations of the given sequence. This is achieved using recursion and
    // every permutation generated is stored in some other data structure (here we
    // have used a vector). Finally, we sort the data structure in which we have
    // stored all the sequences and return the Kth sequence from it.

    // Optimal Solution below:
    // https://takeuforward.org/data-structure/find-k-th-permutation-sequence/

    public static String getPermutation(int n, int k) {

        ArrayList<Character> strChars = new ArrayList<>();
        int factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial = factorial * i;
            strChars.add((char) (i + '0'));
        }
        strChars.add((char) (n + '0'));

        String result = "";

        k--;
        while (true) {

            int pos = k / factorial;
            result = result + strChars.get(pos);
            strChars.remove(pos);

            if (strChars.size() == 0) {
                break;
            }

            k = k % factorial;
            factorial = factorial / strChars.size();

        }

        return result;

    }

    public static void main(String[] args) {
        String result = getPermutation(4, 17);
        System.out.println(result);

    }

}
