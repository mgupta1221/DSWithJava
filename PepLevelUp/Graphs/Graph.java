package PepLevelUp.Graphs;

import java.util.ArrayList;

/**
 * Graph has multiple vertices and multiple Edges. Graph is represented via a
 * Adjacency List which is an array of ArrayList and
 * Each index (graph[0..n]) in this array represent 1 vertex and and stores all
 * edges on that vertex
 * e.g. graph[0]= new ArrayList<Edge>()
 * 
 * Edge of the graph is denoted by 2 cordinates (src and dest) and the weight
 * 
 * Se Graph image in this folder GraphImage.png
 * 
 * Explnation of Graph structure is in first 5 minutes of this video
 * https://www.youtube.com/watch?v=mlnnJd9k7oE&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=2
 */
class Edge {
    public int src;
    public int dest;
    public int wt;

    public Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}

public class Graph {

    public int v;

    public ArrayList<Edge>[] getGraph() {
        int vertices = 7;
        // main Graph object(notice how we have initiliazed 'array' of ArrayList)
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        // Initialising ArrayLists
        for (int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));
        graph[3].add(new Edge(3, 2, 10));
        graph[0].add(new Edge(0, 3, 10));
        graph[3].add(new Edge(3, 0, 0));
        graph[3].add(new Edge(3, 4, 10));
        graph[4].add(new Edge(4, 3, 10));

        graph[4].add(new Edge(4, 5, 10));
        graph[5].add(new Edge(5, 4, 10));

        graph[5].add(new Edge(5, 6, 10));
        graph[6].add(new Edge(6, 5, 10));

        graph[4].add(new Edge(4, 6, 10));
        graph[6].add(new Edge(6, 4, 10));
        return graph;
    }

}
