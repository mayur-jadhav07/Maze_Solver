/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 * Maze Solver application using JFrame.
 * This program creates a maze and displays it on a JFrame.
 * The maze is represented as a 2D array, and the solver's path is stored in a List.
 * The maze is displayed with different colors for walls, open paths, and the end point.
 *
 * @author jmayu
 */
public class Maze_Solver extends JFrame {

    // Representation of the maze as a 2D array
    private final int[][] maze =
    {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    // List to store the path of the solver
    public List<Integer> path = new ArrayList<>();

    /**
     * Constructor for the Maze_Solver class.
     * Initializes the JFrame properties.
     */
    public Maze_Solver() {
        setTitle("Maze Solver");
        setSize(640, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DepthFirstSearch.searchPath(maze, 1, 1, path);
        System.out.println(path);
    }

    /**
     * Overrides the paint method to draw the maze on the JFrame.
     *
     * @param g The Graphics object used for drawing.
     */
    @Override
    public void paint(Graphics g) {
        // Calculate the centering offset
    int offsetX = (getWidth() - maze[0].length * 30) / 2;
    int offsetY = (getHeight() - maze.length * 30) / 2;

    // Iterate through the maze array to draw cells
    for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[0].length; j++) {
            Color color;
            // Determine the color based on the value in the maze array
            color = switch (maze[i][j]) {
                case 1 -> Color.BLACK;   // Wall
                case 9 -> Color.RED;     // End point
                default -> Color.WHITE;  // Open path
            };

            // Set the color, fill the rectangle, and draw the rectangle border
            g.setColor(color);
            g.fillRect(offsetX + 30 * j, offsetY + 30 * i, 30, 30);
            g.setColor(Color.RED);
            g.drawRect(offsetX + 30 * j, offsetY + 30 * i, 30, 30);
        }
    }

    // Draw the path rectangles aligned with the grid
    for (int i = 0; i < path.size(); i += 2) {
        int pathX = path.get(i);
        int pathY = path.get(i + 1);

        // Calculate the position to align with the grid
        int pathRectX = offsetX + 30 * pathX + 5;  // Swap X and Y for proper alignment
        int pathRectY = offsetY + 30 * pathY + 5;  // Swap X and Y for proper alignment

        // Draw the green rectangle for the path
        g.setColor(Color.GREEN);
        g.fillRect(pathRectX, pathRectY, 20, 20);
    }
    }

    /**
     * Main method to create an instance of Maze_Solver and make it visible.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Maze_Solver view = new Maze_Solver();
        view.setVisible(true);
    }
}
