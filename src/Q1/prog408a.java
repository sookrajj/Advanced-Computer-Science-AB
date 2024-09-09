package Q1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prog408a {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/prg408a.dat"));
            var matrix = new int[21][2];
            for (int i = 0; i < 21; i++) {
                matrix[i][0] = input.nextInt();
                matrix[i][1] = input.nextInt();
            }
            input.close();

            System.out.println("ID\tScore");
            for (int[] row : matrix) {
                System.out.println(row[0] + "\t" + row[1]);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void bubbleSortMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length-i-1; j++) {
                if (mat[j][1] < mat[j+1][1]) {
                    int[] temp = mat[j];
                    mat[j] = mat[j+1];
                    mat[j+1] = temp;
                }
            }
        }
    }
}
//ID	Score
//365	265
//222	223
//306	262
//203	224
//113	243
//208	242
//213	229
//115	257
//302	242
//223	230
//311	256
//323	245
//321	245
//123	253
//104	239
//112	239
//207	228
//325	246
//116	246
//218	243
//110	238