package hw8;


import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a graph constructed from a CSE222Map.
 */
public class CSE222Graph {
    private final Map<String, Node> nodes; // Nodes are stored using a HashMap

    /**
     * Constructs a new instance of CSE222Graph with the specified CSE222Map.
     *
     * @param map The CSE222Map used to construct the graph.
     */
    public CSE222Graph(CSE222Map map) {
        nodes = new HashMap<>();
        constructGraph(map);
    }

    /**
     * Constructs the graph from the given CSE222Map.
     *
     * @param map The CSE222Map used to construct the graph.
     */
    public void constructGraph(CSE222Map map) {
        /*if(!map.checkStartandEndPoint()){
            System.out.println("obstacle region");
            System.exit(0);
        }*/
        int rows = map.getxSize();
        int cols = map.getySize();

        // Create nodes for each (y,x) coordinate with value 0
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (map.map[y][x] == 0) {
                    Node node = new Node(x, y);
                    String key = getNodeKey(x, y); // Generate the key for the node
                    nodes.put(key, node); // Add the node to the HashMap
                }
            }
        }

        for (Node node : nodes.values()) {
            int x = node.getX();
            int y = node.getY();

            // Check neighboring coordinates
            for (int dy = -1; dy <= 1; dy++) {
                for (int dx = -1; dx <= 1; dx++) {
                    if (dx == 0 && dy == 0) {
                        continue; // Skip the current node
                    }

                    int nx = x + dx;
                    int ny = y + dy;

                    if (isValidCoordinate(nx, ny, cols, rows) && map.map[ny][nx] == 0) {
                        String neighborKey = getNodeKey(nx, ny); // Get the key for the neighboring node
                        Node neighbor = nodes.get(neighborKey); // Get the neighboring node from the HashMap
                        if (neighbor != null) {
                            node.addEdge(neighbor);
                        }
                    }
                }
            }
        }
    }

    /**
     * Checks if the given coordinates are valid within the specified bounds.
     *
     * @param x     The x-coordinate to check.
     * @param y     The y-coordinate to check.
     * @param cols  The number of columns in the map.
     * @param rows  The number of rows in the map.
     * @return true if the coordinates are valid, false otherwise.
     */
    private boolean isValidCoordinate(int x, int y, int cols, int rows) {
        return x >= 0 && x < cols && y >= 0 && y < rows;
    }

    /**
     * Returns the key for a node with the given coordinates.
     *
     * @param x The x-coordinate of the node.
     * @param y The y-coordinate of the node.
     * @return The key for the node in the format "x-y".
     */
    private String getNodeKey(int x, int y) {
        return x + "-" + y;
    }

    /**
     * Returns the nodes in the graph.
     *
     * @return A map of nodes, where the keys are the node coordinates in the format "x-y".
     */
    protected Map<String, Node> getNodes() {
        return nodes;
    }
}
