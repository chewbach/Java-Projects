package hw8;

import java.util.ArrayList;
import java.util.List;

/**
 * The Node class represents a node in a graph.
 */
public class Node {
    private Point coordinates;
    private List<Node> neighbors;

    /**
     * Constructs a Node with the specified coordinates.
     *
     * @param x the x-coordinate of the node
     * @param y the y-coordinate of the node
     */
    public Node(int x, int y) {
        coordinates = new Point(x, y);
        neighbors = new ArrayList<>();
    }

    /**
     * Returns the x-coordinate of the node.
     *
     * @return the x-coordinate
     */
    public int getX() {
        return coordinates.getX();
    }

    /**
     * Returns the y-coordinate of the node.
     *
     * @return the y-coordinate
     */
    public int getY() {
        return coordinates.getY();
    }

    /**
     * Returns the list of neighboring nodes.
     *
     * @return the list of neighbors
     */
    public List<Node> getNeighbors() {
        return neighbors;
    }

    /**
     * Adds a neighboring node to the list of neighbors.
     *
     * @param neighbor the neighboring node to add
     */
    public void addEdge(Node neighbor) {
        neighbors.add(neighbor);
    }
}
