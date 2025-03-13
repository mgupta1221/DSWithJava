package PepLevelUp.Graphs;

import java.util.ArrayList;

public class FindAllPaths {

    public static void main(String[] args) {
        // Creating Graph
        Graph graph = new Graph();
        ArrayList<Edge>[] gr = graph.getGraph();

        // solution
        boolean[] visited = new boolean[7];
        int src = 0;
        int dest = 6;
        checkIfPathExists(gr, src, dest, visited, "0");
    }

    private static void checkIfPathExists(ArrayList<Edge>[] gr, int src, int dest, boolean[] visited, String path) {
        if (src == dest) {
            System.out.println(path);
            return;
        }

        // Notice in below loop - Graph is array of ArrayList, us pe jab loop lagayenge
        // to Edge milegi
        visited[src] = true;
        for (Edge edge : gr[src]) {
            if (visited[edge.dest] == false) { // notice here we are checking visited of dest, not src
                checkIfPathExists(gr, edge.dest, dest, visited, path + " " + edge.dest);
            }
        }
        visited[src] = false;
    }
}
