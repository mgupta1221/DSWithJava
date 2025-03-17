package Blind75.Arrays;

import java.util.HashSet;

public class LongestSubstrWthoutRepeatChars3 {

    public int LongestSubStringWithReapeatingChars(String s) {
        int maxLength = 0;
        int indexTobeRemoved = 0;
        int currentIndex = 0;
        HashSet<Character> hs = new HashSet<>();
        while (currentIndex < s.length()) {
            Character ch = s.charAt(currentIndex);
            if (hs.contains(ch)) {
                hs.remove(s.charAt(indexTobeRemoved));
                indexTobeRemoved++;
            } else {
                currentIndex++;
                hs.add(ch);
            }
            maxLength = Math.max(maxLength, hs.size());
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstrWthoutRepeatChars3 lswrc = new LongestSubstrWthoutRepeatChars3();
        String s = "aab";
        System.out.println(lswrc.LongestSubStringWithReapeatingChars(s));
    }
}
