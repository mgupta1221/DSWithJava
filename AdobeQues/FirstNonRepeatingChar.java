package AdobeQues;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1

// Problem: Given an input stream A of n characters consisting only of lower case alphabets. 
// While reading characters from the stream, you have to tell which character has appeared only once in the stream 
// upto that point. If there are many characters that have appeared only once, you have to tell which one of them was 
// the first one to appear. If there is no such character then append '#' to the answer.

// Approach:
// Follow the below steps to solve the given problem:

// Take map to check the uniqueness of an element.
// Take queue to find first non-repeating element.
// Traverse through the string and increase the count of elements in map and push in to queue is count is 1.
// If count of front element of the queue > 1 anytime then pop it from the queue until we get unique element at the front.
// If queue is empty anytime append answer string with ‘#’ else append it with front element of queue.
// return answer string.

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
