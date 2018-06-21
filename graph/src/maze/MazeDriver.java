package maze;

import java.io.File;
import java.util.List;

public class MazeDriver {
    public static void main(String[] args) throws Exception {
        File maze1 = new File("D://maze1.txt");
       execute(maze1);
    }

    private static void execute(File file) throws Exception {
        Maze maze = new Maze(file);
        bfs(maze);
    }

    private static void bfs(Maze maze) {
        BFSMazeSolver bfs = new BFSMazeSolver();
        List<Coordinate> path = bfs.solve(maze);
        maze.printPath(path);
        maze.reset();
    }

}