package Blind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphValidTree261 {

    // Solution video: https://www.youtube.com/watch?v=NBSXzs8mrOQ
    // Helper videos->
    // Idea of Adjacency list for graph: https://www.youtube.com/watch?v=J9d9o1DROpk
    // BFS on a graph: https://www.youtube.com/watch?v=_SE_IxMbzV0

    // Graph is a valid tree:
    // 1) If graph with n nodes have (n-1) edges
    // 2) If graph is connected. means all nodes are reachable from all nodes.

    // If above conditions are met than there will no cycle.

    // So we will check first condition by checking (n-1==m)
    // To check whether graph is connected or not , we will run a BFS traversal on
    // graph, and we will visit all nodes only once(using visited array) and we
    // maintain a count and increase it everyone a new node is visted in BFS. If at
    // the end count is same number of node, that means graph is connected(means all
    // nodes are reached).

    public static boolean validTree(int n, int[][] edges) {
        int m = edges.length;

        if (n - 1 != m) { // checking 1st condition above
            return false;
        }

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            al.get(edges[i][0]).add(edges[i][1]);
            al.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n];

        q.add(0);
        int cnt = 1;
        visited[0] = 1;

        while (!q.isEmpty()) {
            int i = q.poll();

            for (int neighbour : al.get(i)) {
                if (visited[neighbour] == 0) {
                    visited[neighbour] = 1;
                    cnt++;
                    q.add(neighbour);
                }
            }

        }
        if (cnt == n) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        System.out.println(validTree(n, edges));

    }
}
