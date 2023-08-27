package AdobeQues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// Problem: https://practice.geeksforgeeks.org/problems/1646a9b5169d7571cf672f2a31533af083d1f479/1

// Approach: Use BFS: Queue 
//https://www.youtube.com/watch?v=Pp7zLmmLcms

//1. We initialize Prime array first between all numbers from 1...9999 (Check the logic in contructor function)
//2. We create  a help class named 'Node'to  maintain both the current number and distance(times to reach this number)
//3. We apply BFS to calculate Shortest path
//4. We maintain viisted array to avoid recomputation
//5. We also apply backtracikng(using prevChar variable) to re-set the value again before the loop ends inside BFS logic
//6. Inside BFS, logic hum ek element ko jab pop karenge uske saare digits ko replace karenge from 0-9 and 'queue' mai add karte jayenge
//7. In if condition we also apply condition num>=1000 becuase we need 4 digit number only
// Important - Notice the way digits are changed in num and the inner loop using char to put values 0-9 for replacement 
// Notice - this is important while assigning values in constructor as code will fail in GFG. See Node class

public class ShortestPrimePath {

    int[] prime;

    ShortestPrimePath() {
        prime = new int[10000];// initialize Prime array
        Arrays.fill(prime, 1);
        prime[0] = 0; // 0 and 1 are non-prime so setting to 0
        prime[1] = 0;
        for (int i = 2; i < 10000; i++) {
            if (prime[i] == 0)
                continue;
            for (int j = 2; i * j < 10000; j++) {
                prime[i * j] = 0;
            }
        }
    }

    public int shortestPath2(int Num1, int Num2) {

        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> st = new HashSet<>();

        q.offer(Num1);
        st.add(Num1);

        int cnt = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                int x = q.poll();
                if (x == Num2)
                    return cnt;
                char[] s = ("" + x).toCharArray();

                for (int i = 0; i < 4; i++) {

                    char c = s[i];
                    for (int j = 0; j <= 9; j++) {
                        if (i == 0 && j == 0)
                            continue;
                        s[i] = (char) (j + '0');
                        int newVal = Integer.parseInt(new String(s));
                        if (prime[newVal] == 1 && !st.contains(newVal)) {
                            st.add(newVal);
                            q.add(newVal);
                        }
                    }
                    s[i] = c;
                }
            }
            cnt++;
        }
        return -1;
    }

    public int shortestPath(int Num1, int Num2) {
        Deque<Node> q = new LinkedList<>();
        Boolean[] vis = new Boolean[10000];
        Arrays.fill(vis, false);

        q.add(new Node(Num1, 0));
        vis[Num1] = true;// setting the first num to be visited
        // Applying BFS
        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            int num = currentNode.num;
            if (num == Num2) // if we reach num2 return the current distance and end
                return currentNode.dist;

            char[] chars = Integer.toString(num).toCharArray();
            for (int i = 0; i <= 3; i++) {
                for (char ch = '0'; ch <= '9'; ch++) {
                    char prevChar = chars[i]; // backtracikng
                    chars[i] = ch; // changing the (ith) character [0th-3rd charcter]
                    int newNum = Integer.parseInt(new String(chars)); // converting char to real number
                    if (!vis[newNum] && prime[newNum] == 1 && newNum >= 1000) { // >=1000 becuase we need 4 digit number
                                                                                // only
                        vis[newNum] = true;
                        q.add(new Node(newNum, currentNode.dist + 1));
                    }
                    chars[i] = prevChar; // backtracking
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int Num1 = 1033;
        int Num2 = 8179;
        ShortestPrimePath so = new ShortestPrimePath();
        int result = so.shortestPath(Num1, Num2);
        System.out.println(result);

    }

    class Node { // Helper class
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

}
