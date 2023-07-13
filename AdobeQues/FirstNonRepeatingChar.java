package AdobeQues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1

// Problem: Given an input stream A of n characters consisting only of lower case alphabets. 
// While reading characters from the stream, you have to tell which character has appeared only once in the stream 
// upto that point. If there are many characters that have appeared only once, you have to tell which one of them was 
// the first one to appear. If there is no such character then append '#' to the answer.

public class FirstNonRepeatingChar {

    public static String FirstNonRepeating(String A) {
        // ArrayList<Character> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < A.length(); i++) {
            Character ch = A.charAt(i);

            if (!map.containsKey(ch)) {
                queue.add(ch);
            }

            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                result.append(queue.peek());
            } else {
                result.append("#");
            }

        }

        return result.toString();

    }

    public static void main(String[] args) {
        String input = "aabc";
        String res = FirstNonRepeating(input);
        System.out.println(res);
    }

}
