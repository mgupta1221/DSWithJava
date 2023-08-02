package AdobeQues;

import java.util.LinkedList;
import java.util.Queue;

// Problem: https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem4816/

// https://www.youtube.com/watch?v=1pMNYQmtVVg

// Approach: 
// Uisng Graph's BFS approach using Queue

// Custom node object will take care of 2 things:
// vertex:  The current node index i.e. 1..n and 
// diceCount: How many times dice has been rolled to reach that node. This is required 
// becuase we have to return the minimum number of times dice is rolled to reach the end
// We are also maintaining 'visited' to make sure we dont visit the node cell again.

public class SnakeAndLadders {
    static int minThrow(int N, int arr[]) {

        int[] board = new int[31];

        // creating 1-D board first
        for (int i = 1; i <= 30; i++) {
            board[i] = i;
        }
        // Notice +2 in loop, as the stating point of ladders or snakes only matter
        for (int i = 0; i < 2 * N; i += 2) {
            board[arr[i]] = arr[i + 1];
        }

        Queue<Node> q = new LinkedList<>();
        boolean[] vis = new boolean[31];

        Node node = new Node();
        node.vertex = 1;// starting from 1
        node.diceCount = 0;

        q.add(node);

        int ans = node.diceCount; // this will store answer
        while (!q.isEmpty()) {
            Node cNode = q.poll();
            if (cNode.vertex == 30) {
                ans = cNode.diceCount;
                break;
            }
            if (cNode.vertex > 30) {
                continue;
            }
            // Rolling dice from cell from 1-6
            for (int i = cNode.vertex + 1; i <= cNode.vertex + 6 && i <= 30; i++) {
                if (vis[i] != true) {
                    vis[i] = true;
                    Node newNode = new Node();
                    newNode.diceCount = cNode.diceCount + 1;
                    newNode.vertex = board[i]; // [board[i] is (node vertex+1) till (node vertex+6)
                    q.add(newNode); /// adding to queue

                }
            }

        }
        return ans;
    }

    static class Node {
        public int vertex;
        public int diceCount;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 22, 5, 8, 11, 26, 20, 29,
                17, 4, 19, 7, 27, 1, 21, 9 };
        int N = 8;
        int result = minThrow(N, arr);
        System.out.println(result);
    }
}
