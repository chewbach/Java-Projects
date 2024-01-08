package hw8;

import java.util.*;

/**
 * This class implements the Dijkstra's algorithm on a CSE222Graph to find the shortest path.
 */
public class CSE222Dijkstra {
    private final CSE222Graph graph;
    protected int length;

    /**
     * Constructs a new instance of CSE222Dijkstra with the specified graph.
     *
     * @param graph The graph on which the Dijkstra's algorithm will be performed.
     */
    public CSE222Dijkstra(CSE222Graph graph) {
        this.graph = graph;
    }

    /**
     * Finds the shortest path between the given start and end points using Dijkstra's algorithm.
     *
     * @param startPoint The starting point of the path.
     * @param endPoint   The ending point of the path.
     * @return A list of nodes representing the shortest path from the start point to the end point. If no path is found, null is returned.
     */
    public List<Node> findShortestPath(Point startPoint, Point endPoint) {
        // Initialize distance map and visited set
        Map<String, Node> nodes = graph.getNodes();
        Node startNode = nodes.get(getNodeKey(startPoint.getX(), startPoint.getY()));
        Node endNode = nodes.get(getNodeKey(endPoint.getX(), endPoint.getY()));
        Map<Node, Integer> distances = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        // Initialize distance to start node as 0 and other nodes as infinity
        for (Node node : graph.getNodes().values()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(startNode, 0);

        // Create a priority queue to store nodes based on their distances
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        queue.offer(startNode);

        // Create a map to store the previous node for each node in the shortest path
        Map<Node, Node> previousNodes = new HashMap<>();

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            visited.add(currentNode);

            if (currentNode.equals(endNode)) {
                // Shortest path found, backtrack from end node to start node
                List<Node> shortestPath = new ArrayList<>();
                Node node = endNode;
                while (node != null) {
                    shortestPath.add(0, node);
                    this.length++;
                    node = previousNodes.get(node);
                }
                return shortestPath;
            }

            // Update distances of neighboring nodes
            for (Node neighbor : currentNode.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    int distance = distances.get(currentNode) + 1; // Assuming all edge weights are 1
                    if (distance < distances.get(neighbor)) {
                        distances.put(neighbor, distance);
                        previousNodes.put(neighbor, currentNode);
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return null; // No path found
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
