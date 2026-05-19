package model;

import ai.Perceptron;
import java.util.Random;

public class MazeBuilder 
{

    private static final Random random = new Random();

    public static Tile[][] runMaze(int rows, int cols) 
    {
        Tile[][] maze = new Tile[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++) 
            {
                TileType type = selectTileType();
                int res = random.nextInt(11); 
                maze[i][j] = new Tile(type, res, i, j);
            }
        }
        calculateDistances(maze);
        return maze;
    }

    private static TileType selectTileType() 
    {
        int val = random.nextInt(100);
        if (val < 60) return TileType.GRASS;      
        else if (val < 85) return TileType.WATER; 
        else return TileType.OBSTACLE;           
    }

    private static void calculateDistances(Tile[][] maze) 
    {
        int row = maze.length;
        int col = maze[0].length;
        for (int i = 0; i < row; i++) 
        {
            for (int j = 0; j < col; j++) {
                int minDist = Integer.MAX_VALUE;
                for (int x = 0; x < row; x++) 
                {
                    for (int y = 0; y < col; y++) 
                    {
                        if (maze[x][y].getType() == TileType.OBSTACLE)
                        {
                            int dist = Math.abs(i - x) + Math.abs(j - y);
                            minDist = Math.min(minDist, dist);
                        }
                    }
                }
                maze[i][j].setDistanceToObstacle(minDist == Integer.MAX_VALUE ? 10 : minDist);
            }
        }
    }

    public static boolean[][] checkTile(Tile[][] maze, Perceptron perceptron) 
    {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] safe = new boolean[rows][cols];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                Tile tile = maze[i][j];
                if (tile.getType() != TileType.OBSTACLE) 
                {
                    double[] input = new double[]{
                        tile.getType() == TileType.GRASS ? 0 : 1,
                        tile.getElevation(),
                        tile.getDistanceToObstacle()
                    };
                    safe[i][j] = perceptron.predict(input) == 1;
                } 
                else 
                {
                    safe[i][j] = false;
                }
            }
        }

        return safe;
    }
}
