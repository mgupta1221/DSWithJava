package StriverSheet.Day10_RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

        for (int i = 1; i <= len; i++) { // abcde

            String subStr = str.substring(0, i);// ab
            if (!wordDict.contains(subStr)) {
                continue;
            } else {
                if (wordBreakHelper(str.substring(i), wordDict, dp)) {
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
