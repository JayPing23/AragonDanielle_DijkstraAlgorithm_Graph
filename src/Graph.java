import java.util.Arrays;

/**
 * Represents a graph using an adjacency matrix.
 */
public class Graph {
    private int[][] adjacencyMatrix;
    private Vertex[] vertices;

    /**
     * Constructs a new graph with a specified number of vertices.
     * @param vertexCount The number of vertices in the graph.
     */
    public Graph(int vertexCount) {
        adjacencyMatrix = new int[vertexCount][vertexCount];
        vertices = new Vertex[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            Arrays.fill(adjacencyMatrix[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < vertexCount; i++) {
            vertices[i] = new Vertex("V" + i);
        }
    }

    /**
     * Adds an edge between two vertices with a specified weight.
     * @param from The index of the source vertex.
     * @param to The index of the destination vertex.
     * @param weight The weight of the edge.
     */
    public void addEdge(int from, int to, int weight) {
        adjacencyMatrix[from][to] = weight;
        adjacencyMatrix[to][from] = weight; // Assuming an undirected graph
    }

    /**
     * Gets the number of vertices in the graph.
     * @return The number of vertices.
     */
    public int getVertexCount() {
        return vertices.length;
    }

    /**
     * Gets the adjacency matrix representing the graph.
     * @return The adjacency matrix.
     */
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    /**
     * Gets a specific vertex by index.
     * @param index The index of the vertex.
     * @return The vertex at the specified index.
     */
    public Vertex getVertex(int index) {
        return vertices[index];
    }
}
