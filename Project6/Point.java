package hw8;

/**
 * The Point class represents a point in a coordinate system.
 */
public class Point {
    private int x;
    private int y;

    /**
     * Constructs a Point object with default coordinates (0, 0).
     */
    protected Point() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructs a Point object with the specified coordinates.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    protected Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of the point.
     *
     * @return the x-coordinate
     */
    protected int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the point.
     *
     * @return the y-coordinate
     */
    protected int getY() {
        return y;
    }

    /**
     * Sets the x-coordinate of the point to the specified value.
     *
     * @param x the new x-coordinate
     */
    protected void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of the point to the specified value.
     *
     * @param y the new y-coordinate
     */
    protected void setY(int y) {
        this.y = y;
    }
}
