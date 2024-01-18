import java.util.Arrays;

/**
 * Represents Dijkstra's algorithm for finding the shortest paths in a graph.
 */
public class DijkstraAlgorithm {
    private int[] distance;
    private boolean[] visited;
    private Graph graph;

    /**
     * Constructs a new DijkstraAlgorithm instance for a given graph.
     * @param graph The graph to apply Dijkstra's algorithm on.
     */
    public DijkstraAlgorithm(Graph graph) {
        this.graph = graph;
        int vertexCount = graph.getVertexCount();
        distance = new int[vertexCount];
        visited = new boolean[vertexCount];
        Arrays.fill(distance, Integer.MAX_VALUE);
    }

    /**
     * Finds the shortest paths from a specified start vertex using Dijkstra's algorithm.
     * @param startVertex The index of the start vertex.
     */
    public void findShortestPath(int startVertex) {
        Arrays.fill(visited, false);

        System.out.println("Traversal:");
        distance[startVertex] = 0;

        for (int i = 0; i < graph.getVertexCount(); i++) {
            int minVertex = getMinimumDistanceVertex();
            visited[minVertex] = true;

            printTraversal(minVertex);

            for (int j = 0; j < graph.getVertexCount(); j++) {
                if (!visited[j] && graph.getAdjacencyMatrix()[minVertex][j] != Integer.MAX_VALUE) {
                    int newDistance = distance[minVertex] + graph.getAdjacencyMatrix()[minVertex][j];
                    if (newDistance < distance[j]) {
                        distance[j] = newDistance;
                    }
                }
            }
        }
    }

    /**
     * Finds the vertex with the minimum distance value among the unvisited vertices.
     * @return The index of the vertex with the minimum distance.
     */
    private int getMinimumDistanceVertex() {
        int minDistance = Integer.MAX_VALUE;
        int minVertex = -1;

        for (int i = 0; i < graph.getVertexCount(); i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minVertex = i;
            }
        }

        return minVertex;
    }

    /**
     * Prints the traversal during each step.
     * @param currentVertex The index of the current vertex.
     */
    private void printTraversal(int currentVertex) {
        System.out.print(graph.getVertex(currentVertex).getName() + " -> ");
    }

    /**
     * Gets the array of shortest distances from the start vertex to each vertex in the graph.
     * @return The array of shortest distances.
     */
    public int[] getShortestDistances() {
        return distance;
    }
}
