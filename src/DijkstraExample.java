import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Example class demonstrating the usage of Dijkstra's algorithm with user input.
 */
public class DijkstraExample {
    public static void main(String[] args) {
        try {
            // Create a graph with 5 vertices
            Graph graph = new Graph(5);

            // Add edges to the graph
            graph.addEdge(0, 1, 2);
            graph.addEdge(0, 2, 4);
            graph.addEdge(1, 2, 1);
            graph.addEdge(1, 3, 7);
            graph.addEdge(2, 4, 3);
            graph.addEdge(3, 4, 1);
            System.out.println();
            // Print the graph for visualization
            printGraph(graph);
            System.out.println();
            // Get user input for the starting vertex
            Scanner scanner = new Scanner(System.in);
            int startVertex = getValidVertexInput(scanner, graph.getVertexCount());
            System.out.println();
            // Apply Dijkstra's algorithm on the graph starting from the user-specified vertex
            DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
            dijkstra.findShortestPath(startVertex);
            System.out.println();
            // Print the shortest distances from the start vertex to all other vertices
            printShortestDistances(graph, dijkstra, startVertex);
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static void printGraph(Graph graph) {
        System.out.println("Graph:");
        int[][] adjacencyMatrix = graph.getAdjacencyMatrix();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(adjacencyMatrix[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    private static int getValidVertexInput(Scanner scanner, int vertexCount) {
        while (true) {
            try {
                System.out.print("Enter the index of the vertex (0 to " + (vertexCount - 1) + "): ");
                int vertex = scanner.nextInt();

                if (vertex >= 0 && vertex < vertexCount) {
                    return vertex;
                } else {
                    System.out.println("Invalid input. Please enter a valid vertex index.");
                }
            } catch (InputMismatchException e) {
                // Clear the buffer in case of invalid input
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    private static void printShortestDistances(Graph graph, DijkstraAlgorithm dijkstra, int startVertex) {
        // Get and print the shortest distances from the start vertex
        int[] shortestDistances = dijkstra.getShortestDistances();
        System.out.println("\nShortest distances from start vertex (V" + startVertex + ") to all other vertices:");
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println(graph.getVertex(i).getName() + ": " + shortestDistances[i]);
        }
    }
}
