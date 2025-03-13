package PepLevelUp.Graphs;

import java.util.ArrayList;

public class CheckIfPathExistInGraph {

    public static void main(String[] args) {
        // Creating Graph
        Graph graph = new Graph();
        ArrayList<Edge>[] gr = graph.getGraph();

        //
        boolean[] visited = new boolean[7];
        int src = 0;
        int dest = 6;
        boolean result = checkIfPathExists(gr, src, dest, visited);
        System.out.println(result);
    }

    private static boolean checkIfPathExists(ArrayList<Edge>[] gr, int src, int dest, boolean[] visited) {
        if (src == dest)
            return true;

        // Notice in below loop - Graph is array of ArrayList, us pe jab loop lagayenge
        // to Edge milegi
        visited[src] = true;
        for (Edge edge : gr[src]) {
            if (visited[edge.dest] == false) { // notice here we are checking visited of dest, not src
                boolean result = checkIfPathExists(gr, edge.dest, dest, visited);
                if (result == true) {
                    return true;
                }
            }
        }
        return false;

    }
}
