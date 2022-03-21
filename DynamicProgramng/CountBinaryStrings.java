package DynamicProgramng;

public class CountBinaryStrings {

    // Question link:
    // https://nados.pepcoding.com/content/0/1c04bbdb-eb09-4a19-ac25-3900ef3d2568/

    // Solution video:
    // https://www.youtube.com/watch?v=nqrXHJWMeBc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=18

    // Question is you are given a number n
    /// You are required to print the number of binary strings of length n with no
    // consecutive 0's.

    // Approach is we keep 2 counters , for length n:
    // First counter for all numbers ending with 0
    // Second counter for all numbers ending with 1

    // To calcuate numbers ending with zero , we consider last iteration's count of
    // numbers ending with 1

    // To calcuate numbers ending with ones , we consider last iteration's count of
    // numbers ending with 1 + numbers ending with 0

    public static void main(String[] args) {

        int n = 6;
        int cZeroes = 1;
        int cOnes = 1;

        for (int i = 2; i <= n; i++) {
            int temp = cZeroes;// creating temp to preserve number of zeroes to update cOnes later
            cZeroes = cOnes;
            cOnes = temp + cOnes;
        }

        // Printing total numbers without consequence zeroes of length n
        System.out.println(cZeroes + cOnes);
    }

}