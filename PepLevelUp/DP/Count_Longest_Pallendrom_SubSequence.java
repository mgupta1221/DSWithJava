package PepLevelUp.DP;

// LC 516
// for Str= "abc"
// Possible subsequences are ""(empty string), "a", "b", "c", "ab", "ac", "bc", "abc"
// Total number of subsequences are 2^n  (in this case 2^3= 8)

// Logic video:
// https://www.youtube.com/watch?v=RiNzHfoA2Lo
// Watch the first half part video, ignore the video when he start 2D array thing..
// Solution code :
//https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
public class Count_Longest_Pallendrom_SubSequence {

    public static int count_Longest_Pallndromic_Subsequence(String str, int i, int j) {

        // Base Case 1: If there is only 1 character
        if (i == j) {
            return 1;
        }
        // Base Case 2: If there are only 2 characters and both are same
        else if (str.charAt(i) == str.charAt(j) && (i + 1) == j) {
            return 2;
        }
        // If the first and last characters are same e.g. 'ABDBA' -- agar first or last
        // charcter same hain to LPS iske andar hi milega
        // Plus 2 isliye kiya hai kyunki 'ABDBA' agar string hai to 'BDB' ke liye
        // recursive
        // call lagayi aur first 'A' or last 'A'
        // ka count 2 add kar diya
        else if (str.charAt(i) == str.charAt(j)) {
            return count_Longest_Pallndromic_Subsequence(str, i + 1, j - 1) + 2;
        }
        // agar first aur last charcter same nahi hain e.g. 'ABDB' to
        // LPS ya to 'ABD' ya 'BDB' mai milega..aur hume longest lena hoga via
        // Math.max()
        return Math.max(count_Longest_Pallndromic_Subsequence(str, i + 1, j),
                count_Longest_Pallndromic_Subsequence(str, i, j - 1));

    }

    public static void main(String[] args) {
        String str = "abkccbe";
        int result = count_Longest_Pallndromic_Subsequence(str, 0, str.length() - 1);
        System.out.println(result);
    }

}
