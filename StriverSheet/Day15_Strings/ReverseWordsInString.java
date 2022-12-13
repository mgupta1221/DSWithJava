package StriverSheet.Day15_Strings;

public class ReverseWordsInString {

    // Problem: LC 151 https://leetcode.com/problems/reverse-words-in-a-string/

    // Apparoch 1 : Normal impementation and with in-built functions
    // Approach 2: Using String Builder
    // Approach 3: Without using InBuild functions
    public static String reverseWords(String s) {
        if (s.length() == 0) {
            return "";
        }

        String[] temp = s.split(" ");
        String result = "";
        for (int i = temp.length - 1; i >= 0; i--) {
            if (!temp[i].equals(""))
                result += temp[i] + " ";
        }
        return result.trim();

    }

    // Using String builder
    public static String reverseWords2(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int end = words.length - 1;
        for (int i = 0; i <= end; i++) {
            if (!words[i].isEmpty()) {
                sb.insert(0, words[i]);// rememeber 'insert' method of StringBuilder, it will add at 'offset position
                                       // which is front in this case'
                System.out.println(sb.toString());
                if (i < end)
                    sb.insert(0, " ");
            }
        }
        return sb.toString();
    }

    // 3rd approach without using InBuild functions
    // Below methods without using InBuilt functions

    public static StringBuilder trimSpaces(String str) {
        /// first creating starting index(left) and ending index(right) by removing
        /// empty spaces at start and at end
        int left = 0;
        int right = str.length() - 1;
        while (left <= str.length() - 1 && str.charAt(left) == ' ') {
            left++;
        }
        while (right >= 0 && str.charAt(right) == ' ') {
            right--;
        }

        // creating a new string now
        StringBuilder sb = new StringBuilder();
        while (left < right) {
            if (str.charAt(left) != ' ')
                sb.append(str.charAt(left));
            else if (sb.charAt(sb.length() - 1) != ' ') { // notice how we removed contiguous blank spaces
                sb.append(str.charAt(left));
            }
            left++;
        }
        return sb;
    }

    public static void reverseSingleWords(StringBuilder sb) {
        int start = 0;
        int end = 0;

        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ')
                end++;

            reverse(sb, start, end - 1);
            start = end + 1;
            end++;
        }

    }

    public static void reverse(StringBuilder sb, int i, int j) {
        while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i++, sb.charAt(j));
            sb.setCharAt(j--, temp);
        }

        // or use simpler approach:
        // String revString = "";
        // for (int k = s.length() - 1; k >= 0; --k) {
        // revString += s.charAt(k);
        // }
        // System.out.println(revString);
    }

    public static void main(String[] args) {
        String s = "the sky    is  blue ";
        // s = "a good example";
        // String result = reverseWords(s); // Approach 1

        // String result = reverseWords2(s); // Approach 2
        // System.out.println(result);

        // Approach 3
        // Whole processing is done on StingBuilder (not String)
        // Step 1: Trim all spaces(Corner spaces and reduce contiguous spaces to 1)
        StringBuilder trimmedStr = trimSpaces(s);
        // Step 2: reverse the entire trimmed string
        reverse(trimmedStr, 0, trimmedStr.length() - 1);
        // Step 3: rRverse individual words
        reverseSingleWords(trimmedStr);
        // String reversed = new String(chs);
        System.out.println(trimmedStr);

    }

}
