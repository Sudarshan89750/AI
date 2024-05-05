import java.util.*;

class Algo {
    private int V;
    private LinkedList<Integer>[] adj;

    public Algo(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int neighbor : adj[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public void BFS(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            for (int neighbor : adj[s]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}

public class Graph {
    public static void main(String[] args) {
        // Define the graph structure
        int numberOfVertices = 5; // Change this value as needed
        Algo g = new Algo(numberOfVertices);
        // Add edges manually
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        // Perform DFS and BFS on the graph
        int startVertex = 0; // Change this value as needed
        System.out.println("DFS of Graph:");
        g.DFS(startVertex);
        System.out.println();

        System.out.println("BFS of Graph:");
        g.BFS(startVertex);
    }
}
