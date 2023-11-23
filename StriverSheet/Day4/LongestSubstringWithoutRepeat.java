package StriverSheet.Day4;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {

    // LC 3:
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/

    // Solution: https://www.youtube.com/watch?v=dvXyTOYVxB8

    // Approach:
    // Sliding Window
    // Traverse the string characters and maintain 2 variables: i and j
    // starting from 0. As we traverse ,we will keep storing characters in
    // hashSet(and keep increasing currentIndex as we move in while loop). If a
    // repeated element appears, we will remove last occured element increasw
    // 'removal index' by 1 at each removal (sliding window).

    // Answer Hashset ke size() ki max value se nikaalna hai

    // imagine 'abca' - jab second wala 'a' aayega to first 'a' ko hashset se
    // remove karna hai 'indexTobeRemoved pointer' use karke aur 'indexTobeRemoved
    // pointer' increase karna hai taaki wo 'b' ko point karega

    public static int lengthOfLongestSubstring(String str) {
        if (str.length() == 0) {
            return 0;
        }
        HashSet<Character> hSet = new HashSet<>();
        // Maintain 2 pointers - One for currentIndex and one for item to be removed
        // when duplicate
        int currentIndex = 0;
        int indexTobeRemoved = 0;
        int maxLength = 0;

        while (currentIndex < str.length()) {
            char currentChar = str.charAt(currentIndex);
            // agar repeat element aata hai to pehle jo occur hua use remove karna
            // hai HashSet se.. aur pointer(removal Pointer) increase karna hai uske baad..
            // Important: currentIndex increase nahi hoga in case duplicate element aata
            // hai because hume new element ko consider karna hai next iteration mai
            if (hSet.contains(currentChar)) {
                maxLength = Math.max(maxLength, hSet.size());
                hSet.remove(str.charAt(indexTobeRemoved));
                indexTobeRemoved++;// increasing the pointer to remove if the next element reappears
            } else {
                hSet.add(currentChar); // if no duplicate keep adding to HashSet
                currentIndex++; /// only increase if NO duplicate element occurs
            }
        }
        maxLength = Math.max(maxLength, hSet.size());
        return maxLength;

    }

    public static void main(String[] args) {
        String s = "pwwkew";

        int result = lengthOfLongestSubstring(s);
        System.out.println(result);

    }
}
