package Blind75.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static Boolean wordBreak(String str, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        return wordBreakHelper(str, set);

    }
    // Catanddog -- Cat an and dog

    public static Boolean wordBreakHelper(String str, HashSet<String> set) {

        int len = str.length();
        if (len == 0) {
            return true;
        }

        for (int i = 0; i < len; i++) {
            String currentStr = str.substring(0, i + 1);
            if (set.contains(currentStr)) {
                String remainderStr = str.substring(i + 1, len);
                if (wordBreakHelper(remainderStr, set) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "leetcode";
        List<String> wordDict = List.of("leet", "code");

        // String str = "qycjcdlgappppbmcxppbpbmcxppqycjcdlga";
        // List<String> wordDict = new ArrayList<>();
        // wordDict.add("b");
        // wordDict.add("qycjcdlga");
        // wordDict.add("pbmcx");
        // wordDict.add("p");
        System.out.println(wordBreak(str, wordDict));
    }
}
