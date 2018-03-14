/*
 * A Program that solves a simple or complex maze and gives coordinates as output.
 * By @Jordan Hill
 * The Coordinates that are outputted are the path that needs to be taken to get through the maze, that being the dots
 * that it uses for the path, laying out each one in the form of an array. 
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class MazeSolver {
    /*
     * While this may be unneccasry to document, the start of the public class outlines 5 things that the program needs to run,
     * those being the Stacks, for the X and Y coordinates, showing the coordinates of the Path and 
     * the Shortest possible way to complete that path. Then we move onto the main array, that being 
     * static int list[][]. This is responsible for storing the maze in the space, and then we move onto
     * the purpose of the static boolean checked[][], which checks the path, and validates the points in the
     * maze and whether it is true or not, and uses that to validate it, whether it being part of the path or not, and then moves into using
     * the static int length[], using that to check the array spot, and the length of the position of where it is at 
     * within the maze. Then the two stacks I use allow it to be printed in X and Y coordinates, using the stacks to do so, as the program moves 
     * through solving the maze, and as each layer of the maze is popped off and a new stack is used, as the maze, an array in this case, gets
     * smaller and smaller, and as it does this, taking each point that is valid, and using that as the valid path to do so, printing each one in the 
     * terminal window as a set of coordinates showing these points on the path in which it is the shortest possible path to move through the maze.
     * The Stacks also serve as a function for serving as storing each row of characters in the maze that is scanned and eventually prints out the 
     * coordinates of the maze (aka the solution of the maze of course) and prints it out into the terminal, or if there is no
     * solution, it does not print that out. 
     */
    static int list [][] = new int[1000][1000];
    static boolean checked[][] = new boolean[1000][1000];
    static int length[] = new int[2];
    static Stack<Integer>locationx = new Stack<Integer>();
    static Stack<Integer>locationy = new Stack<Integer>();
    /*
     * The first parameter of this method is scanning the .txt file containing the maze, and preparing it to be scanned/
     * The second parameter of this method is determining what the characters are in the maze, and what position they are at, 
     * then taking the end, (the $ sign), and records it as the final position, for the last part of the main method, in 
     * which the y coordinate, the row number, is scanned and inputted as a long. 
     * Finally, the return value of this method is the two coordinates of the path printed out, detailing the shortest 
     * path that would need to be taken, and prints it out the help of the other method of this program, the maze method, which is responsible for
     * pushing and moving the stack around to find the shortest path within the maze, making the final return value of this program either a 
     * solved maze, or a maze that cannot be solved, printing out the return value in a simple line of text, being No Solution to the maze can be found
     * therefore making the maze unsolvable.
     */
    public static void main(String[]args) {
        try{
            Scanner scan;
            scan = new Scanner(new BufferedReader(new FileReader("maze.txt")));
            int start[] = new int[2];
            int interations = 0;
            while(scan.hasNextLine()) {
                String holder = scan.nextLine();
                for(int i = 0; i < holder.length(); i++) {
                    length[0] = holder.length();
                    if(holder.charAt(i) == '@') {
                        list[i][interations] = 1;
                        start[0] = i;
                        start[1] = interations;
                    }
                    else if(holder.charAt(i) == '.') {
                        list[i][interations] = 1;
                    }
                    else if(holder.charAt(i) == '#') { 
                        list[i][interations] = 2;
                    }
                    else if(holder.charAt(i) == '$') {
                        list[i][interations] = 3;  
                    }
                }
                interations++;
            }
            length[1] = interations;

            if(maze(start[0], start[1])) {
                for(long i = locationy.length; i > 0; i--) {
                    System.out.println(locationy.pop() + "," + locationx.pop());
                }
            } else {
                System.out.println("No Solution");
            }
        }catch (IOException e) {
            System.out.println("Something is wrong, You can't code and gotta git gud.");
            System.exit(0);
        }
    }
    
    /*
     * The First parameter of this program is checking for the X Coordinates of the Maze and the solution coordinates, and scans for every 
     * possible row, and then sends that position to the main method, and prints it out in the x coordinate in the main method with the Y coordinate.
     * The Second Parameter of this program is Checking for the Y Coordinate at all possibilties, with it working very similarry to the first Parameter of this method, 
     * and in the main method is paired together with the x coordinate, bringing us to the return value.
     * The Return Value of this method are whether the maze has the correct coordinate solutions, and also checks if its true or false, and this method then is 
     * put to work in the main method, and prints out the coordinate solutions for the maze as the final return value of this method that I have just explained. 
     */
    public static boolean maze(int x, int y) { 
        checked[x][y] = true;
        if(list[x][y] == 3) {
            locationx.push(x);
            locationy.push(y);
            return true;
        }
        if(x < length[0] && !checked[x + 1][y] && list[x + 1][y] != 2 &&  list[x + 1][y] != 0) {
            if(maze(x + 1,y)) {
                locationx.push(x);
                locationy.push(y);
                return true;
            }
        }
        if(x > 0 && !checked[x - 1][y] && list[x - 1][y] != 2 && list[x - 1][y] != 0) {
            if(maze(x - 1,y)) {
                locationx.push(x);
                locationy.push(y);
                return true;
            }
        }
        if(y < length[1] && !checked[x][y + 1] && list[x][y + 1] != 2 && list[x][y + 1] != 0) {
            if(maze(x, y + 1)) {
                locationx.push(x);
                locationy.push(y);
                return true;
            }
        }
        if(y > 0 && !checked[x][y - 1] && list[x][y - 1] != 2 && list[x][y - 1] != 0) {
            if(maze(x, y -1)) {
                locationx.push(x);
                locationy.push(y);
                return true;
            }
        }        
        return false;
    } 
}