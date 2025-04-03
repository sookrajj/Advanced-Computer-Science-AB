package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class msoe2009_8 {
    public static void processor(char[][] mat, int x, int y, int prex, int prey) {
        if (x > mat.length-1 || x < 0 || y > mat[x].length-1 || y < 0) return;
        else {
            if (mat[x][y] == '*' && mat[prex][prey] != '*') {
                mat[x][y] = mat[prex][prey];
                processor(mat, x+1, y, x, y);
                processor(mat, x, y+1, x, y);
                processor(mat, x-1, y, x, y);
                processor(mat, x+1, y+1, x, y);
                processor(mat, x+1, y-1, x, y);
                processor(mat, x-1, y+1, x, y);
                processor(mat, x-1, y-1, x, y);
                processor(mat, x, y-1, x, y);
            }
        }
    }

    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/image1.txt"));
            var mat = new char[input.nextInt()][input.nextInt()];
            input.nextLine();
            int num = 0;
            while (input.hasNext()) {
                var line = input.nextLine().toCharArray();
                mat[num] = line;
                num++;
            }
            for (char[] c : mat) {
                for (char t : c) {
                    System.out.print(t);
                }
                System.out.println();
            }
            var Alpha = "ABCDEFGHIJ";
            var p = 0;
            for (int i = 0; i < mat.length-1; i++) {
                for (int l = 0; l < mat[i].length-1; l++) {
                    if (mat[i][l] == '*') {
                        mat[i][l] = Alpha.charAt(p);
                        p++;
                        processor(mat, i+1, l, i, l);
                        processor(mat, i, l+1, i, l);
                        processor(mat, i-1, l, i, l);
                        processor(mat, i+1, l+1, i, l);
                        processor(mat, i+1, l-1, i, l);
                        processor(mat, i-1, l+1, i, l);
                        processor(mat, i-1, l-1, i, l);
                        processor(mat, i, l-1, i, l);
                    }
                }
            }
            System.out.println();
            for (char[] c : mat) {
                for (char t : c) {
                    System.out.print(t);
                }
                System.out.println();
            }

            input.close();
        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}

//  **   **  ****
//   ** **  *
//   * * *   ***
//   *   *      *
//  **   ** ****
//
//
//
//   ***   *****
//  *   *  *
//  *   *  ***
//  *   *  *
//   ***   *****
//
//  AA   AA  BBBB
//   AA AA  B
//   A A A   BBB
//   A   A      B
//  AA   AA BBBB
//
//
//
//   CCC   DDDDD
//  C   C  D
//  C   C  DDD
//  C   C  D
//   CCC   DDDDD

//  ***  ***  ****
//  * *   *   ****
//   **  **   **
// *  *       * *
// * **********  *
// *
//
//
//  AAA  BBB  AAAA
//  A A   B   AAAA
//   AA  BB   AA
// C  A       A A
// C AAAAAAAAAA  A
// C
//