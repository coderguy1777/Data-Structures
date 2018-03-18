/*
 * MazeSolver
 * By @Jordan Hill
 * Solves a maze and displays the coordinates of the path.
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class MazeSolver {
    //Used for storing the maze in an array, using the three arrays below.
    public static int mazearray [][] = new int[1000][1000];
    public static boolean seen[][] = new boolean[1000][1000];
    public static int length[] = new int[2];
    //Stacks that display the row and column coordinates of the maze path, and are used in displaying the final solution of the maze using the main method. 
    public static Stack<Integer>RowCoordinate = new Stack<Integer>();
    public static Stack<Integer>ColCoordinate = new Stack<Integer>();
    /*
     * The First Parameter of this method is finding the Row Coordinate of the maze that can be used in the solution.
     * The Second Parameter of this method is finding the Column Coordinate of the maze that can be used in the solution. 
     * The Return value of this Method is the Row and Column coordinates being validated as true and used in the final 
     * solution, that it being printed in the main method.
     */
    public static boolean coordinatefinder(int a, int b) { 
        // This Prevents the Stack from making itself Overflow.
        seen[a][b] = true;
        //This is used for allowing the return of the final solution, once the program of the end of the maze. 
        if(mazearray[a][b] == 3) {
            RowCoordinate.push(a);
            ColCoordinate.push(b);
            return true;
        }
        //All of these are used for Checking the place of the path, and 
        //Seeing if there is a path that is solvable, and from these makes
        //the eventual final solution. 
        if(a < length[0]){
            if(!seen[a + 1][b]) {
                if(mazearray[a + 1][b] != 2) {
                    if(mazearray[a + 1][b] != 0) {
                        if(coordinatefinder(a + 1,b)) {
                            RowCoordinate.push(a);
                            ColCoordinate.push(b);
                            return true;
                        }
                    }
                }
            }
        }
        if(a > 0) {
            if(!seen[a - 1][b]) {
                if(mazearray[a - 1][b] != 2) {
                    if(mazearray[a - 1][b] != 0) {
                        if(coordinatefinder(a - 1,b)) {
                            RowCoordinate.push(a);
                            ColCoordinate.push(b);
                            return true;
                        }
                    }
                }
            }
        }
        if(b < length[1]) {
            if(!seen[a][b + 1]) {
                if(mazearray[a][b + 1] != 2) {
                    if(mazearray[a][b + 1] != 0) {
                        if(coordinatefinder(a, b + 1)) {
                            RowCoordinate.push(a);
                            ColCoordinate.push(b);
                            return true;
                        }
                    }
                }
            }
        }
        if(b > 0) {
            if(!seen[a][b - 1]) {
                if(mazearray[a][b - 1] != 2) {
                    if( mazearray[a][b - 1] != 0) {
                        if(coordinatefinder(a, b - 1)) {
                            RowCoordinate.push(a);
                            ColCoordinate.push(b);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    /*
     * The First Parameter of this method is scanning the .txt file for the maze.
     * The Second Parameter of this method is storing it into the main array, and stores it to be checked by the boolean method, and then 
     * from that boolean method, the final solution is stored and sent here.
     * The Return value of this method is the final solution of the maze printed in the terminal window. 
     */
    public static void main(String[]args) {
        try{
            //Establishment of the official scanners 
            //File scanner is also established at the start here. 
            Scanner scan;
            scan = new Scanner(new BufferedReader(new FileReader("maze.txt")));
            int front[] = new int[2];

            //Used as Identifting factors for the Scanner to use and the Boolean method to go over correctly when 
            //in the array and scanning for the coordinates to solve the maze properly, also makes it scan into the 
            //array well, and shortens the code by doing this. 
            int repeats = 0; // the int (repeats) identifys the size of the maze, and inputs it in for the characters to be found properly.
            int Path = 1;// Meant to represent (.)in the maze. 
            int Edge = 2;// Meant to represent (#)in the maze. 
            int End = 3;// Meant to represent ($)in the maze. 
            int StartofMaze = 0;// Meant to represent the start of the 
            while(scan.hasNextLine()) {
                String holder = scan.nextLine();
                for(int spotinmaze = 0; spotinmaze < holder.length(); spotinmaze++) {               
                    if(holder.charAt(spotinmaze) == '@') {
                        mazearray[spotinmaze][repeats] = StartofMaze;
                        front[0] = spotinmaze;
                        front[1] = repeats;
                        if(holder.charAt(spotinmaze) != '@') {
                            //This I tried to make work for if the Maze has the start missing, it would print this. 
                            System.out.println("Maze Cannot be solved");
                            break;
                        }
                    }
                    else if(holder.charAt(spotinmaze) == '.') {
                        mazearray[spotinmaze][repeats] = Path;
                        if(holder.charAt(spotinmaze) != '.'){
                            System.out.println("No Path is Present, fix the Path for a solution and run the Program again.");
                            break;
                        }
                    }
                    else if(holder.charAt(spotinmaze) == '#') { 
                        mazearray[spotinmaze][repeats] = Edge;
                        if(holder.charAt(spotinmaze) != '#') {
                            System.out.println("No Edge is Present, Fix the Maze to get a solution.");
                            break;
                        }
                    }
                    else if(holder.charAt(spotinmaze) == '$') {
                        mazearray[spotinmaze][repeats] = End;  
                        if(holder.charAt(spotinmaze) != '$') {
                            System.out.println("No end is Present, fix this to get a solution.");
                            break;
                        }
                    }
                }
                repeats++;
            }
            length[1] = repeats;
            //Prints out Maze with the final solved solution.
            if(coordinatefinder(front[0], front[1])) {
                //Printed if the maze is correct and solvable. 
                for(long spotinmaze = ColCoordinate.length; spotinmaze > 0; spotinmaze--) {
                    System.out.println(ColCoordinate.pop() + "," + RowCoordinate.pop());
                }

            } else {
                //Printed if the maze is unsolvable and can't be solved due to missing componets, etc. 
                System.out.println("IMPOSSIBRU!!!!!!!!!!!!!!!!!!!");
            }
        } catch (IOException e) {
            System.out.println("Something is wrong, You can't code and gotta git gud.");
            System.exit(0);
        }
    }
}