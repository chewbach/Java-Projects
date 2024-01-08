package hw8;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * This class represents a map used for pathfinding algorithms.
 */
public class CSE222Map {
    Point startPoint;
    Point endPoint;
    int[][] map;

    int xSize;
    int ySize;
    String fileName;

    /**
     * Returns the x size of the map.
     *
     * @return The x size of the map.
     */
    int getxSize() {
        return xSize;
    }

    /**
     * Returns the y size of the map.
     *
     * @return The y size of the map.
     */
    int getySize() {
        return ySize;
    }

    /**
     * Constructs a new instance of CSE222Map with the specified parameters.
     *
     * @param fileName The name of the file containing the map data.
     * @param xSize    The x size of the map.
     * @param ySize    The y size of the map.
     */
    public CSE222Map(String fileName, int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.fileName = fileName;
        startPoint = new Point();
        endPoint = new Point();
        map = new int[xSize][ySize];

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (lineNumber == 1) {
                    startPoint.setY(Integer.parseInt(values[0]));
                    startPoint.setX(Integer.parseInt(values[1]));
                } else if (lineNumber == 2) {
                    endPoint.setY(Integer.parseInt(values[0]));
                    endPoint.setX(Integer.parseInt(values[1]));
                } else {
                    for (int i = 0; i < values.length; i++) {
                        if (values[i].equals("-1")) {
                            values[i] = "1";
                        }

                        map[lineNumber - 3][i] = Integer.parseInt(values[i]);
                    }
                }

                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts the map to a PNG image file.
     */
    protected void convertPNG() {
        int width = map.length;
        int height = map[0].length;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixelValue = (map[x][y] == 1) ? 0xFF808080 : 0xFFFFFFFF; // Use 0xFF808080 for grayscale shading
                image.setRGB(x, y, pixelValue);
            }
        }
        String newFileName = this.fileName.substring(0, 5) + ".png";
        try {
            File outputFile = new File(newFileName);
            ImageIO.write(image, "png", outputFile);
            System.out.println("Map converted to PNG.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Draws a red line on the map to represent the path found by Dijkstra's algorithm.
     *
     * @param dijkstra The Dijkstra object used to find the path.
     */
    protected void drawLine(CSE222Dijkstra dijkstra) {
        // Read the map and load it as a BufferedImage object
        String newFileName = this.fileName.substring(0, 5) + "_with_pathDijkstra.png";
        String inputFileName = this.fileName.substring(0, 5) + ".png";
        File inputFile = new File(inputFileName);
        BufferedImage image;
        try {
            image = ImageIO.read(inputFile);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return;
        }

        // Create a Graphics object and draw a red line
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.RED);

        List<Node> path = dijkstra.findShortestPath(startPoint, endPoint);
        for (int i = 0; i < path.size() - 1; i++) {
            Node currentNode = path.get(i);
            Node nextNode = path.get(i + 1);
            int x1 = currentNode.getX();
            int y1 = currentNode.getY();
            int x2 = nextNode.getX();
            int y2 = nextNode.getY();
            graphics.drawLine(y1, x1, y2, x2);
        }

        // Save the image with the drawn line
        File outputFile = new File(newFileName);
        try {
            ImageIO.write(image, "png", outputFile);
            System.out.println("Red line drawn on the map and saved.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Draws a red line on the map to represent the path found by BFS algorithm.
     *
     * @param bfs The BFS object used to find the path.
     */
    protected void drawLine(CSE222BFS bfs) {

        String newFileName = this.fileName.substring(0, 5) + "_with_pathBFS.png";
        String inputFileName = this.fileName.substring(0, 5) + ".png";
        File inputFile = new File(inputFileName);
        BufferedImage image;
        try {
            image = ImageIO.read(inputFile);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return;
        }

        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.RED);

        List<Node> path = bfs.findShortestPath(startPoint, endPoint);
        for (int i = 0; i < path.size() - 1; i++) {
            Node currentNode = path.get(i);
            Node nextNode = path.get(i + 1);
            int x1 = currentNode.getX();
            int y1 = currentNode.getY();
            int x2 = nextNode.getX();
            int y2 = nextNode.getY();
            graphics.drawLine(y1, x1, y2, x2);
        }

        // Save the drawn line
        File outputFile = new File(newFileName);
        try {
            ImageIO.write(image, "png", outputFile);
            System.out.println("Red line drawn on the map and saved.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Writes the shortest path found by BFS algorithm to the console.
     *
     * @param bfs The BFS object used to find the path.
     */
    protected void writePath(CSE222BFS bfs) {
        List<Node> path = bfs.findShortestPath(startPoint, endPoint);
        if (path != null) {
            System.out.println("Shortest path found:");
            for (Node node : path) {
                System.out.println("Node: (" + node.getX() + ", " + node.getY() + ")");
            }
        } else {
            System.out.println("No feasible path found.");
        }
    }

    /**
     * Writes the shortest path found by Dijkstra's algorithm to the console.
     *
     * @param dijkstra The Dijkstra object used to find the path.
     */
    protected void writePath(CSE222Dijkstra dijkstra) {
        List<Node> path = dijkstra.findShortestPath(startPoint, endPoint);
        if (path != null) {
            System.out.println("Shortest path found:");
            for (Node node : path) {
                System.out.println("Node: (" + node.getX() + ", " + node.getY() + ")");
            }
        } else {
            System.out.println("No feasible path found.");
        }
    }

    protected boolean checkStartandEndPoint(){
        if(map[startPoint.getX()][startPoint.getY()]!=0 || map[endPoint.getX()][endPoint.getY()]!=0)
            return false;
    return true;
    }
}
