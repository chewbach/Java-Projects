package hw8;

import java.util.*;

/**
 * This class is responsible for performing Breadth-First Search (BFS) algorithm on CSE222Graph to find the shortest path.
 */
public class CSE222BFS {
    private final CSE222Graph graph;
    protected int length;

    /**
     * Constructs a new instance of CSE222BFS with the specified graph.
     *
     * @param graph The graph on which the BFS algorithm will be performed.
     */
    public CSE222BFS(CSE222Graph graph) {
        this.graph = graph;
    }

    /**
     * Finds the shortest path between the given start and end points.
     *
     * @param startPoint The starting point of the path.
     * @param endPoint   The ending point of the path.
     * @return A list of nodes representing the shortest path from the start point to the end point. If no path is found, an empty list is returned.
     */
    public List<Node> findShortestPath(Point startPoint, Point endPoint) {
        Map<String,Node> nodes = graph.getNodes();
        Node startNode = nodes.get(getNodeKey(startPoint.getX(),startPoint.getY()));
        Node endNode = nodes.get(getNodeKey(endPoint.getX(),endPoint.getY()));
        List<Node> path = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parentMap = new HashMap<>();

        queue.offer(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode == endNode) {
                return reconstructShortestPath(parentMap, currentNode);
            }

            List<Node> neighbors = currentNode.getNeighbors();
            for (Node neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);

                    parentMap.put(neighbor, currentNode);
                }
            }
        }

        return path; // Shortest path not found
    }

    /**
     * Reconstructs the shortest path from the parent map starting from the given end node.
     *
     * @param parentMap The map containing the parent-child relationships of the nodes.
     * @param endNode   The end node from which the path will be reconstructed.
     * @return A list of nodes representing the shortest path from the start node to the end node.
     */
    private List<Node> reconstructShortestPath(Map<Node, Node> parentMap, Node endNode) {
        List<Node> path = new ArrayList<>();
        Node currentNode = endNode;

        while (currentNode != null) {
            path.add(currentNode);
            this.length++;
            currentNode = parentMap.get(currentNode);
        }

        Collections.reverse(path);
        return path;
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
}
