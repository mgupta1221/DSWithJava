package PepLevelUp.Graphs;

import java.util.ArrayList;

class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int src, int d, int w) {
        this.src = src;
        this.dest = d;
        this.wt = w;
    }
}

public class Graph2 {
    // Adjacency List
    public Graph2(int vertices) {
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(2, 1, 10));
    }

}
