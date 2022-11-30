package StriverSheet.Day11_BinarySearch;

import java.util.ArrayList;

public class BookAllocation {

    // https://www.interviewbit.com/problems/allocate-books/

    // Similar quesiton on LC is :
    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

    // Solution approach (Good Explanation):
    // https://www.youtube.com/watch?v=gYmWHvRHu-s

    // Approach is Binary search use hoga kyunki Sorted array ka quesiton.
    // Binary search mai range define karni hoti hai for 'low' and 'high' wo range
    // is case mai 0 - sum of all element hogi..kyunki answer isi ke beech maii lie
    // karega

    // Now We will try to allocate pages to students such that no student shoud have
    // more than 'mid' number of pages allocated..Why? becuase we want 'mid' to be
    // our answer. This decision whether such division is possible in 'B' students
    // or not is done in 'isPossible' function.`

    // aur idea ye hai ki ek bande ko 'mid' se jayada pages ki book allocate nahi
    // hogi. 'isPossible' function isi ke base par likhna hai jo ye decide karke
    // batayega ki total books N, 'B' students ko allocate ki ja sakti hain ya nahi
    // keeping 1 condition that any student should NOT have more than 'mid' number
    // of pages in books allocated to each of them. Agar allocate ho sakti hain to
    // hum aur further minimum value dhudenge as asked in the quesiton by setting
    // high=mid-1, else move to bigger half of the array

    // main function
    public static int books(int[] pages, int B) {
        int sumOfAllElements = 0;
        for (int n : pages) {
            sumOfAllElements += n;
        }

        int low = 0;
        int high = sumOfAllElements;
        while (low <= high) {
            int mid = (low + (high)) / 2;
            if (isPossible(pages, mid, B)) {
                // agar mid se combination possible hai to mujhe aur minimum value nikalani
                // isliye 'high' will reduce and we will find a lesser value possible
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;// Important: always return low here, not high

    }

    // helper function
    public static boolean isPossible(int[] arr, int barrier, int B) {

        int allocatedStudent = 1; // start this with 1 becuase at least 1 element will always be 1
        int pagesSum = 0;

        for (int i = 0; i < arr.length; i++) {

            // this below condition is important for test cases.. kabhi bhi elements 'mid'
            // se badhe nahi hona chhaiye..kyunki fir allocation possible hi nahi hoga

            if (arr[i] > barrier) // IMPORTANT this is forgetable condition so do remember to put this
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

    public static void main(String[] args) {
        // int[] A = { 12, 34, 67, 90 };
        // int B = 2;

        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int B = 10;
        System.out.println("Minimum Possible Number is " + books(A, B));
    }
}