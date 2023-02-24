package StriverSheet.Day10_RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Problem: https://leetcode.com/problems/word-break/
public class WordBreak {

    public static Boolean wordBreak(String str, List<String> wordDict) {
        HashSet<String> hashDict = new HashSet<>();
        for (String s : wordDict) {
            hashDict.add(s);
        }
        HashMap<String, Boolean> dp = new HashMap<>();

        return wordBreakHelper(str, hashDict, dp);

    }

    public static boolean wordBreakHelper(String str, HashSet<String> wordDict, HashMap<String, Boolean> dp) {

        int len = str.length();
        if (str.length() == 0)
            return true;

        if (dp.containsKey(str))
            return dp.get(str);

        // To remember to start the loop from 1 , not 0
        for (int i = 1; i <= len; i++) { // abcde

            String subStr = str.substring(0, i);// ab --- i will be excluded
            if (!wordDict.contains(subStr)) {
                continue;
            } else {
                if (wordBreakHelper(str.substring(i), wordDict, dp)) { // dont return directly, return only if value is
                                                                       // true
                    dp.put(str, true);
                    return true;
                }
            }
        }
        dp.put(str, false);
        return false;

    }

    public static void main(String[] args) {

        String str = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");

        Boolean result = wordBreak(str, wordDict);
        System.out.println(result);

    }

}
