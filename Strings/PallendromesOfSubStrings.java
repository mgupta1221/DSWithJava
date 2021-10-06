package Strings;

public class PallendromesOfSubStrings {

    // Quesiton: https://www.youtube.com/watch?v=_jM3iMT4k7g
    public static void main(String[] args) {

        String str = "abccbc";
        String resultString = "";

        for (int i = 0; i < str.length(); i++) {

            for (int j = i + 1; j <= str.length(); j++) {
                resultString = str.substring(i, j);
                if (isPallendrome(resultString)) {
                    System.out.println(resultString + " is pallendrome.");
                } else {
                    System.out.println(resultString + " is not pallendrome.");
                }
            }
            //

        }

    }

    static boolean isPallendrome(String str) {
        int low = 0;
        int high = str.length() - 1;
        boolean result = true;

        while (low < high) {
            char leftChar = str.charAt(low); // Notice how we pick charcters by index
            char rightChar = str.charAt(high);
            if (leftChar != rightChar) { 
                result = false;
                break;
            }
            low++;
            high--;
        }
        return result;
    }

}
