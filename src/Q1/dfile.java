package Q1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class dfile {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/Replace.dat"));

            while (input.hasNext()) {

            }
            input.close();
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}

