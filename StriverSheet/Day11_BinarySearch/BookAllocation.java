package StriverSheet.Day11_BinarySearch;

import java.util.ArrayList;

public class BookAllocation {

    // https://www.interviewbit.com/problems/allocate-books/

    // Solution approach:
    // https://www.youtube.com/watch?v=gYmWHvRHu-s

    // Approach is Binary search use hoga kyunki Sorted array ka quesiton.
    // Binary search mai range define karni hoti hai for 'low' and 'high' wo range
    // is case mai 0 - sum of all element hogi

    // aur idea ye hai ki ek bande ko 'mid' se jayada pages ki book allocate nahi
    // hogi. 'isPossible' function isi ke base par likhna hai jo ye decide karke
    // batayega ki ki total books N, 'B' students ko allocate ki ja sakti hain
    // keeping 1 condition that any student should NOT have more than mid number of
    // pages in books allocated to each of them. Agar allocate ho sakti hain to hum
    // aur further minimum value dhudenge as asked in the quesiton by setting
    // high=mid-1, else move to bigger half of the array

    // helper function
    public static boolean isPossible(int[] arr, int barrier, int B) {

        int allocatedStudent = 0;
        int pagesSum = 0;

        for (int i = 0; i < arr.length; i++) {

            if (pagesSum > barrier) // this condition is important.. kabhi bhi sum barrier se upar nahi hona chhaiye
                                    // shuru mai hi check kar lo
                return false;

            if (pagesSum + arr[i] > barrier) {
                allocatedStudent += 1;
                pagesSum = arr[i];
            } else {
                pagesSum += arr[i];
            }
        }
        if (allocatedStudent < B) {
            return true;
        } else {
            return false;
        }

    }

    // main function
    public static int books(int[] pages, int B) {
        int sumOfAllElements = 0;
        for (int n : pages) {
            sumOfAllElements += n;
        }

        int low = pages[0];
        int high = sumOfAllElements;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(pages, mid, B)) {
                // agar mid se combination possible hai to mujhe aur minimum value nikalani
                // isliye 'high' will reduce and we will find a lesser value possible
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

    public static void main(String[] args) {
        int[] A = { 12, 34, 67, 90 };

        int B = 2;
        System.out.println("Minimum Possible Number is " + books(A, B));
    }
}