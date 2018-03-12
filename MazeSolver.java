/*
 * A Program that solves a simple or complex maze and gives coordinates as output.
 * By @Jordan Hill
 */
import java.io.*;
import java.util.Scanner;
import java.util.*;
public class MazeSolver {

    static int list [][] = new int[10000][10000];
    static boolean checked[][] = new boolean[20000][20000];
    static int length[] = new int[2];

    static Stack<Integer>locationxposition = new Stack<Integer>();
    static Stack<Integer>locationyposition = new Stack<Integer>();
    public static void main(String[]args) {
        try{
            Scanner scan;
            scan = new Scanner(new BufferedReader(new FileReader("maze.txt")));

            int start[] = new int[2];
            scan.useDelimiter(",");

            int interations = 0;
            while(scan.hasNextLine()) {
                String holder = scan.nextLine();
                for(int i = 0; i < holder.length();i++) {
                    length[0] = holder.length();
                    if(holder.charAt(i) == '@') {
                        list[i][interations] = 1;
                        start[0] = i;
                        start[1] = interations;
                    }
                    else if(holder.charAt(i) == '.') {
                        list[i][interations] = 1;
                    }
                    else if(holder.charAt(i) == '$') {
                        list[i][interations] = 2;
                    }
                    else if(holder.charAt(i) == '#') {
                        list[i][interations] = 3;
                    }
                    interations++;
                }
                length[1] = interations;

                if(maze(start[0], start[1])) {
                    for(long i =locationyposition.pop(); i > 0; i++) {
                        System.out.println(locationxposition.pop() + " , " + locationyposition.pop());
                    }

                } else {
                    System.out.println("No Solution is here for the Maze and the Shortest Path.");
                }
            }

        } catch (IOException e) {
            System.out.println("Something is wrong, You can't code and gotta git gud.");
            System.exit(0);
        }
    }
    public static boolean maze(int x, int y) {
        checked[x][y] = true;
    }
}

