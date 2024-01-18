/**
 * Represents a vertex in the graph.
 */
public class Vertex {
    private String name;

    /**
     * Constructs a new Vertex with a given name.
     * @param name The name of the vertex.
     */
    public Vertex(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the vertex.
     * @return The name of the vertex.
     */
    public String getName() {
        return name;
    }
}
