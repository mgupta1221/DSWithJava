package StriverSheet.Day16_StringII;

// Problem: https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/

// Approach 1: Naive approach: Start checking the string each time if it is a palindrome and if not, then delete 
// the last character and check again. When the string gets reduced to either a palindrome or an empty string 
// then the number of characters deleted from the end till now will be the answer as those characters could have been
// inserted at the beginning of the original string in the order which will make the string a palindrome.

// Approach 2: KMP Algo


public class MinimumCharsToMakePalindrome {

    public static boolean isPallendrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;

            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "BABABAA";
        int charsRemoved = 0;

        System.out.println(isPallendrome(s));
        while (!isPallendrome(s)) {
            charsRemoved++;
            s = s.substring(0, s.length() - 1);
            System.out.println(s);
        }

        System.out.println(charsRemoved);

        // // print the number of insertion at front
        // if (flag == 1) {
        // System.out.println(cnt);
        // }
    }
}
