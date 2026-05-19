package model;

public class Tile {
    private TileType type;
    private int height;
    private int distanceToObstacle;
    private int x_axis, y_axis;

    public Tile(TileType type, int elevation, int x_axis, int y_axis) 
    {
        this.type = type;
        this.height = elevation;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.distanceToObstacle = -1; //////////// 
    }

    public TileType getType() {
        return type;
    }

    public int getElevation() {
        return height;
    }

    public int getDistanceToObstacle() {
        return distanceToObstacle;
    }

    public void setDistanceToObstacle(int distance) {
        this.distanceToObstacle = distance;
    }

    public int getX() {
        return x_axis;
    }

    public int getY() {
        return y_axis;
    }
}
