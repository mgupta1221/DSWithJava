package PepLevelUp.RecursionTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak_LC139 {

    private static boolean SolveWordBreak(String str, String asf, HashSet<String> wordDict) {
        if (str.length() == 0) {
            System.out.println(asf);// this is not required, but we are using it
            // to print all set of sentences which are possible
            return true;
        }

        // Notice we are starting loop with 1, NOT 0
        for (int i = 1; i <= str.length(); i++) {
            String tempStr = str.substring(0, i);
            if (wordDict.contains(tempStr)) {
                if (SolveWordBreak(str.substring(i), asf + " " + tempStr, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean wordBreak(String str, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<>();
        for (String s : wordDict) {
            hashSet.add(s);
        }
        boolean result = SolveWordBreak(str,"", hashSet);
        return result;
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        // String[] words = { "i", "like", "sam", "sung", "samsung", "mobile", "ice",
        // "cream", "icecream", "man", "go", "mango" };

        String[] words = { "leet", "code" };

        for (String str : words) {
            list.add(str);
        }

        boolean result = wordBreak("leetcode", list);
        System.out.println(result);

    }
}
