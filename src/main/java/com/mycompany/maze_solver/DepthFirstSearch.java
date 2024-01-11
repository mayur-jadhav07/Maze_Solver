/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.util.List;

/**
 * Depth First Search algorithm to search for a path in a maze.
 * This class provides a method to search for a path from the start to the end point in a given maze.
 * The maze is represented as a 2D array, where 1 represents a wall, 0 represents an open path,
 * and 9 represents the end point.
 * The algorithm uses recursion to explore possible paths.
 *
 * @author jmayu
 */
public class DepthFirstSearch {

    /**
     * Search for a path in the maze using Depth First Search.
     *
     * @param maze The maze represented as a 2D array.
     * @param x    The current x-coordinate.
     * @param y    The current y-coordinate.
     * @param path List to store the path coordinates.
     * @return True if a path is found, false otherwise.
     */
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path) {
        // Check if the end point is reached
        if (maze[y][x] == 9) {
            path.add(x);
            path.add(y);
            return true;
        }
        // Check if the current cell is an open path
        if (maze[y][x] == 0) {
            // Mark the current cell as visited
            maze[y][x] = 2;

            // Explore possible paths in different directions
            int dx = -1;
            int dy = 0;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 1;
            dy = 0;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = -1;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = 1;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
        }
        // No path found from the current cell
        return false;
    }
}
