import java.io.*;
import java.util.Scanner;
public class StackGenerify {
    public static void main(String[]args) {
       AyManYouraRockStar<Integer> o = new AyManYouraRockStar<Integer>();
       AyManYouraRockStar<Digit> u = new AyManYouraRockStar<Digit>();
       AyManYouraRockStar<Digit> x = new AyManYouraRockStar<Digit>();
       
       o.set(99);
       u.set(new Digit());
       x.setNext();
       x.set(new Digit());
       
       System.out.println(x.get());
       
    }
}