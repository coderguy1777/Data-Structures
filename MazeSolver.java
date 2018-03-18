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
    public static int mazearray [][] = new int[1000][1000];
    public static boolean seen[][] = new boolean[1000][1000];
    public static int length[] = new int[2];
    
    public static Stack<Integer>coordinate1 = new Stack<Integer>();
    public static Stack<Integer>coordinate2 = new Stack<Integer>();
    
    public static boolean maze(int a, int b) { 
        seen[a][b] = true;
        
        if(mazearray[a][b] == 3) {
            coordinate1.push(a);
            coordinate2.push(b);
            return true;
        }
        
        if(a < length[0] && !seen[a + 1][b]){
            if(mazearray[a + 1][b] != 2) {
                if(mazearray[a + 1][b] != 0) {
                    if(maze(a + 1,b)) {
                        coordinate1.push(a);
                        coordinate2.push(b);
                        return true;
                    }
                }
            }
        }
        
        if(a > 0 && !seen[a - 1][b]) {
            if(mazearray[a - 1][b] != 2) {
                if(mazearray[a - 1][b] != 0) {
                    if(maze(a - 1,b)) {
                        coordinate1.push(a);
                        coordinate2.push(b);
                        return true;
                    }
                }
            }
        }
        
        if(b < length[1] && !seen[a][b + 1]) {
            if(mazearray[a][b + 1] != 2) {
                if(mazearray[a][b + 1] != 0) {
                    if(maze(a, b + 1)) {
                        coordinate1.push(a);
                        coordinate2.push(b);
                        return true;
                    }
                }
            }
        }
        
        if(b > 0 && !seen[a][b - 1]) {
            if(mazearray[a][b - 1] != 2) {
                if( mazearray[a][b - 1] != 0) {
                    if(maze(a, b - 1)) {
                        coordinate1.push(a);
                        coordinate2.push(b);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static void main(String[]args) {
        try{
            Scanner scan;
            scan = new Scanner(new BufferedReader(new FileReader("maze.txt")));
            int front[] = new int[2];
            int repeats = 0;
            int Path = 1;
            int Edge = 2;
            int End = 3;
            int StartofMaze = 0;
            while(scan.hasNextLine()) {
                String holder = scan.nextLine();
                for(int spotinmaze = 0; spotinmaze < holder.length(); spotinmaze++) {
                    length[0] = holder.length();
                    if(holder.charAt(spotinmaze) == '@') {
                        mazearray[spotinmaze][repeats] = StartofMaze;
                        front[0] = spotinmaze;
                        front[1] = repeats;
                    }
                    else if(holder.charAt(spotinmaze) == '.') {
                        mazearray[spotinmaze][repeats] = Path;
                    }
                    else if(holder.charAt(spotinmaze) == '#') { 
                        mazearray[spotinmaze][repeats] = Edge;
                    }
                    else if(holder.charAt(spotinmaze) == '$') {
                        mazearray[spotinmaze][repeats] = End;  
                    }
                }
                repeats++;
            }
            length[1] = repeats;
            if(maze(front[0], front[1])) {
                for(long spotinmaze = coordinate2.length; spotinmaze > 0; spotinmaze--) {
                    System.out.println("The solution to your maze is:" + " " + coordinate2.pop() + "," + coordinate1.pop());
                }
            } else {
                System.out.println("IMPOSSIBRU!!!!!!!!!!!!!!!!!!!");
            }
        }catch (IOException e) {
            System.out.println("Something is wrong, You can't code and gotta git gud.");
            System.exit(0);
        }
    }
}