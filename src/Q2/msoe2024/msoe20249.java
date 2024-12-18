package Q2.msoe2024;

import org.junit.Ignore;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.ErrorManager;

public class msoe20249 {

//    public static int recur(String[][] mat, int r, int c) {
//        if (r < 0 || r > mat.length - 1 || c > mat[0].length - 1 || c < 0) return 0;
//        if (r == 0 && c > 0) {
//            if (mat[r][c].equalsIgnoreCase("f") ||
//                    mat[r + 1][c].equalsIgnoreCase("f") ||
//                    mat[r][c - 1].equalsIgnoreCase("f") ||
//                    mat[r + 1][c - 1].equalsIgnoreCase("f") ||
//                    mat[r + 1][c + 1].equalsIgnoreCase("f") ||
//                    mat[r][c + 1].equalsIgnoreCase("f")
//            ) return 0;
//            if (mat[r][c - 1].equals("-")) return recur(mat, r, c - 1);
//            if (mat[r + 1][c - 1].equals("-")) return recur(mat, r + 1, c - 1);
//            if (mat[r + 1][c].equals("-")) return recur(mat, r + 1, c);
//            if (mat[r][c + 1].equals("-")) return recur(mat, r, c + 1);
//            if (mat[r + 1][c + 1].equals("-")) return recur(mat, r + 1, c + 1);
//            if (mat[r][c - 1].equals("s")) return recur(mat, r, c - 1) + 1;
//            if (mat[r + 1][c - 1].equals("s")) return recur(mat, r + 1, c - 1) + 1;
//            if (mat[r][c].equals("s")) return recur(mat, r, c) + 1;
//            if (mat[r + 1][c].equals("s")) return recur(mat, r + 1, c) + 1;
//            if (mat[r][c + 1].equals("s")) return recur(mat, r, c + 1) + 1;
//            if (mat[r + 1][c + 1].equals("s")) return recur(mat, r + 1, c + 1) + 1;
//        } else if (c == 0 && r > 0) {
//            if (mat[r][c].equalsIgnoreCase("f") ||
//                    mat[r - 1][c].equalsIgnoreCase("f") ||
//                    mat[r + 1][c].equalsIgnoreCase("f") ||
//                    mat[r + 1][c + 1].equalsIgnoreCase("f") ||
//                    mat[r][c + 1].equalsIgnoreCase("f") ||
//                    mat[r - 1][c + 1].equalsIgnoreCase("f")
//            ) return 0;
//            if (mat[r - 1][c].equals("-")) return recur(mat, r - 1, c);
//            if (mat[r + 1][c].equals("-")) return recur(mat, r + 1, c);
//            if (mat[r][c + 1].equals("-")) return recur(mat, r, c + 1);
//            if (mat[r - 1][c + 1].equals("-")) return recur(mat, r - 1, c + 1);
//            if (mat[r + 1][c + 1].equals("-")) return recur(mat, r + 1, c + 1);
//            if (mat[r][c].equals("s")) return recur(mat, r, c) + 1;
//            if (mat[r - 1][c].equals("s")) return recur(mat, r - 1, c) + 1;
//            if (mat[r + 1][c].equals("s")) return recur(mat, r + 1, c) + 1;
//            if (mat[r][c + 1].equals("s")) return recur(mat, r, c + 1) + 1;
//            if (mat[r - 1][c + 1].equals("s")) return recur(mat, r - 1, c + 1) + 1;
//            if (mat[r + 1][c + 1].equals("s")) return recur(mat, r + 1, c + 1) + 1;
//        } else if (c == 0 && r == 0) {
//            if (mat[r][c].equalsIgnoreCase("f") ||
//                    mat[r + 1][c].equalsIgnoreCase("f") ||
//                    mat[r + 1][c + 1].equalsIgnoreCase("f") ||
//                    mat[r][c + 1].equalsIgnoreCase("f")
//            ) return 0;
//            if (mat[r + 1][c].equals("-")) return recur(mat, r + 1, c);
//            if (mat[r][c + 1].equals("-")) return recur(mat, r, c + 1);
//            if (mat[r + 1][c + 1].equals("-")) return recur(mat, r + 1, c + 1);
//            if (mat[r][c].equals("s")) return recur(mat, r, c) + 1;
//            if (mat[r + 1][c].equals("s")) return recur(mat, r + 1, c) + 1;
//            if (mat[r][c + 1].equals("s")) return recur(mat, r, c + 1) + 1;
//            if (mat[r + 1][c + 1].equals("s")) return recur(mat, r + 1, c + 1) + 1;
//        }else {
//            if (mat[r][c].equalsIgnoreCase("f") ||
//                    mat[r - 1][c].equalsIgnoreCase("f") ||
//                    mat[r + 1][c].equalsIgnoreCase("f") ||
//                    mat[r][c - 1].equalsIgnoreCase("f") ||
//                    mat[r - 1][c - 1].equalsIgnoreCase("f") ||
//                    mat[r + 1][c - 1].equalsIgnoreCase("f") ||
//                    mat[r + 1][c + 1].equalsIgnoreCase("f") ||
//                    mat[r][c + 1].equalsIgnoreCase("f") ||
//                    mat[r - 1][c + 1].equalsIgnoreCase("f")
//            ) return 0;
//            if (mat[r - 1][c - 1].equals("-")) return recur(mat, r - 1, c - 1);
//            if (mat[r][c - 1].equals("-")) return recur(mat, r, c - 1);
//            if (mat[r + 1][c - 1].equals("-")) return recur(mat, r + 1, c - 1);
//            if (mat[r - 1][c].equals("-")) return recur(mat, r - 1, c);
//            if (mat[r + 1][c].equals("-")) return recur(mat, r + 1, c);
//            if (mat[r][c + 1].equals("-")) return recur(mat, r, c + 1);
//            if (mat[r - 1][c + 1].equals("-")) return recur(mat, r - 1, c + 1);
//            if (mat[r + 1][c + 1].equals("-")) return recur(mat, r + 1, c + 1);
//            if (mat[r - 1][c - 1].equals("s")) return recur(mat, r - 1, c - 1) + 1;
//            if (mat[r][c - 1].equals("s")) return recur(mat, r, c - 1) + 1;
//            if (mat[r + 1][c - 1].equals("s")) return recur(mat, r + 1, c - 1) + 1;
//            if (mat[r][c].equals("s")) return recur(mat, r, c) + 1;
//            if (mat[r - 1][c].equals("s")) return recur(mat, r - 1, c) + 1;
//            if (mat[r + 1][c].equals("s")) return recur(mat, r + 1, c) + 1;
//            if (mat[r][c + 1].equals("s")) return recur(mat, r, c + 1) + 1;
//            if (mat[r - 1][c + 1].equals("s")) return recur(mat, r - 1, c + 1) + 1;
//            if (mat[r + 1][c + 1].equals("s")) return recur(mat, r + 1, c + 1) + 1;
//        }
//        return 1;
//    }

    public static int recur(String[][] mat, int r, int c, int check, int num) {
        boolean s = false;
        if (c < 0) c = 0;
        if (r < 0) r = 0;
        System.out.println(num);
        if (check > 10) {return num;}
        if (mat[r][c].equalsIgnoreCase("f")) {
            System.out.println("hi");
            return num;
        }
        try {
            if (mat[r+1][c].equalsIgnoreCase("f")) return num;
            if (mat[r+1][c+1].equalsIgnoreCase("f")) return num;
            if (mat[r+1][c-1].equalsIgnoreCase("f")) return num;
            if (mat[r][c+1].equalsIgnoreCase("f")) return num;
            if (mat[r][c-1].equalsIgnoreCase("f")) return num;
            if (mat[r-1][c].equalsIgnoreCase("f")) return num;
            if (mat[r-1][c+1].equalsIgnoreCase("f")) return num;
            if (mat[r-1][c-1].equalsIgnoreCase("f")) return num;
//            System.out.println("hi");
        } catch (IndexOutOfBoundsException e) {
            if (r+1 >= mat.length) {
                if (c+1 >= mat[0].length) {
                    if (mat[r][c-1].equalsIgnoreCase("f")) return num;
                    if (mat[r-1][c].equalsIgnoreCase("f")) return num;
                    if (mat[r-1][c-1].equalsIgnoreCase("f")) return num;
                } else if (c - 1 < 0) {
                    if (mat[r][c+1].equalsIgnoreCase("f")) return num;
                    if (mat[r-1][c].equalsIgnoreCase("f")) return num;
                    if (mat[r-1][c+1].equalsIgnoreCase("f")) return num;
                } else {
                    if (mat[r][c+1].equalsIgnoreCase("f")) return num;
                    if (mat[r][c-1].equalsIgnoreCase("f")) return num;
                    if (mat[r-1][c].equalsIgnoreCase("f")) return num;
                    if (mat[r-1][c+1].equalsIgnoreCase("f")) return num;
                    if (mat[r-1][c-1].equalsIgnoreCase("f")) return num;
                }
            } else if (r-1 < 0) {
                if (c+1 >= mat[0].length) {
                    if (mat[r][c-1].equalsIgnoreCase("f")) return num;
                    if (mat[r+1][c].equalsIgnoreCase("f")) return num;
                    if (mat[r+1][c-1].equalsIgnoreCase("f")) return num;
                } else if (c - 1 < 0) {
                    if (mat[r][c+1].equalsIgnoreCase("f")) return num;
                    if (mat[r+1][c].equalsIgnoreCase("f")) return num;
                    if (mat[r+1][c+1].equalsIgnoreCase("f")) return num;
                } else {
                    if (mat[r][c+1].equalsIgnoreCase("f")) return num;
                    if (mat[r][c-1].equalsIgnoreCase("f")) return num;
                    if (mat[r+1][c].equalsIgnoreCase("f")) return num;
                    if (mat[r+1][c+1].equalsIgnoreCase("f")) return num;
                    if (mat[r+1][c-1].equalsIgnoreCase("f")) return num;
                }
            } else {
                if (c+1 >= mat[0].length) {
                    if (mat[r+1][c].equalsIgnoreCase("f")) return num;
                    if (mat[r+1][c-1].equalsIgnoreCase("f")) return num;
                    if (mat[r][c-1].equalsIgnoreCase("f")) return num;
                    if (mat[r-1][c].equalsIgnoreCase("f")) return num;
                    if (mat[r-1][c-1].equalsIgnoreCase("f")) return num;
                } else if (c - 1 < 0) {
                    if (mat[r+1][c].equalsIgnoreCase("f")) return num;
                    if (mat[r+1][c+1].equalsIgnoreCase("f")) return num;
                    if (mat[r][c+1].equalsIgnoreCase("f")) return num;
                    if (mat[r-1][c].equalsIgnoreCase("f")) return num;
                    if (mat[r-1][c+1].equalsIgnoreCase("f")) return num;
//                    System.out.println("hill");
                }
            }
        }
            try {
                if (mat[r + 1][c].equalsIgnoreCase("-")) recur(mat, r + 1, c, check + 1, num);
                if (mat[r + 1][c + 1].equalsIgnoreCase("-")) recur(mat, r + 1, c + 1, check + 1, num);
                if (mat[r + 1][c - 1].equalsIgnoreCase("-")) recur(mat, r + 1, c - 1, check + 1, num);
                if (mat[r][c + 1].equalsIgnoreCase("-")) recur(mat, r, c + 1, check + 1, num);
                if (mat[r][c - 1].equalsIgnoreCase("-")) recur(mat, r, c - 1, check + 1, num);
                if (mat[r - 1][c].equalsIgnoreCase("-")) recur(mat, r - 1, c, check + 1, num);
                if (mat[r - 1][c + 1].equalsIgnoreCase("-")) recur(mat, r - 1, c + 1, check + 1, num);
                if (mat[r - 1][c - 1].equalsIgnoreCase("-")) recur(mat, r - 1, c - 1, check + 1, num);
                s = true;
            } catch (IndexOutOfBoundsException e) {
                if (r + 1 >= mat.length) {
                    if (c + 1 >= mat[0].length) {
                        if (mat[r][c - 1].equalsIgnoreCase("-")) recur(mat, r, c - 1, check + 1, num);
                        if (mat[r - 1][c].equalsIgnoreCase("-")) recur(mat, r - 1, c, check + 1, num);
                        if (mat[r - 1][c - 1].equalsIgnoreCase("-")) recur(mat, r - 1, c - 1, check + 1, num);
                        s = true;
//                        System.out.println(1);
                    } else if (c - 1 < 0) {
                        if (mat[r][c + 1].equalsIgnoreCase("-")) recur(mat, r, c + 1, check + 1, num);
                        if (mat[r - 1][c].equalsIgnoreCase("-")) recur(mat, r - 1, c, check + 1, num);
                        if (mat[r - 1][c + 1].equalsIgnoreCase("-")) recur(mat, r - 1, c + 1, check + 1, num);
                        s = true;
//                        System.out.println(2);
                    } else {
                        if (mat[r][c + 1].equalsIgnoreCase("-")) recur(mat, r, c + 1, check + 1, num);
                        if (mat[r][c - 1].equalsIgnoreCase("-")) recur(mat, r, c - 1, check + 1, num);
                        if (mat[r - 1][c].equalsIgnoreCase("-")) recur(mat, r - 1, c, check + 1, num);
                        if (mat[r - 1][c + 1].equalsIgnoreCase("-")) recur(mat, r - 1, c + 1, check + 1, num);
                        if (mat[r - 1][c - 1].equalsIgnoreCase("-")) recur(mat, r - 1, c - 1, check + 1, num);
                        s = true;
//                        System.out.println(3);
                    }
                } else if (r - 1 < 0) {
                    if (c + 1 >= mat[0].length) {
                        if (mat[r + 1][c].equalsIgnoreCase("-")) recur(mat, r + 1, c, check + 1, num);
                        if (mat[r + 1][c - 1].equalsIgnoreCase("-")) recur(mat, r + 1, c - 1, check + 1, num);
                        if (mat[r][c - 1].equalsIgnoreCase("-")) recur(mat, r, c - 1, check + 1, num);
                        s = true;
//                        System.out.println(4);
                    } else if (c - 1 < 0) {
                        if (mat[r + 1][c].equalsIgnoreCase("-")) recur(mat, r + 1, c, check + 1, num);
                        if (mat[r + 1][c + 1].equalsIgnoreCase("-")) recur(mat, r + 1, c + 1, check + 1, num);
                        if (mat[r][c + 1].equalsIgnoreCase("-")) recur(mat, r, c + 1, check + 1, num);
                        s = true;
//                        System.out.println(5);
                    } else {
                        if (mat[r + 1][c].equalsIgnoreCase("-")) recur(mat, r + 1, c, check + 1, num);
                        if (mat[r + 1][c + 1].equalsIgnoreCase("-")) recur(mat, r + 1, c + 1, check + 1, num);
                        if (mat[r + 1][c - 1].equalsIgnoreCase("-")) recur(mat, r + 1, c - 1, check + 1, num);
                        if (mat[r][c + 1].equalsIgnoreCase("-")) recur(mat, r, c + 1, check + 1, num);
                        if (mat[r][c - 1].equalsIgnoreCase("-")) recur(mat, r, c - 1, check + 1, num);
                        s = true;
//                        System.out.println(6);
                    }
                } else {
                    if (c + 1 >= mat[0].length) {
                        if (mat[r + 1][c].equalsIgnoreCase("-")) recur(mat, r + 1, c, check + 1, num);
                        if (mat[r + 1][c - 1].equalsIgnoreCase("-")) recur(mat, r + 1, c - 1, check + 1, num);
                        if (mat[r][c - 1].equalsIgnoreCase("-")) recur(mat, r, c - 1, check + 1, num);
                        if (mat[r - 1][c].equalsIgnoreCase("-")) recur(mat, r - 1, c, check + 1, num);
                        if (mat[r - 1][c - 1].equalsIgnoreCase("-")) recur(mat, r - 1, c - 1, check + 1, num);
                        s = true;
//                        System.out.println(7);
                    } else if (c - 1 < 0) {
                        if (mat[r + 1][c].equalsIgnoreCase("-")) recur(mat, r + 1, c, check + 1, num);
                        if (mat[r + 1][c + 1].equalsIgnoreCase("-")) recur(mat, r + 1, c + 1, check + 1, num);
                        if (mat[r][c + 1].equalsIgnoreCase("-")) recur(mat, r, c + 1, check + 1, num);
                        if (mat[r - 1][c].equalsIgnoreCase("-")) recur(mat, r - 1, c, check + 1, num);
                        if (mat[r - 1][c + 1].equalsIgnoreCase("-")) recur(mat, r - 1, c + 1, check + 1, num);
                        s = true;
//                        System.out.println(8);
                    }
                }
            }

                try {
                    if (mat[r + 1][c].equalsIgnoreCase("s")) recur(mat, r + 1, c, check + 1, num + 1);
                    if (mat[r + 1][c + 1].equalsIgnoreCase("s")) recur(mat, r + 1, c + 1, check + 1, num + 1);
                    if (mat[r + 1][c - 1].equalsIgnoreCase("s")) recur(mat, r + 1, c - 1, check + 1, num + 1);
                    if (mat[r][c + 1].equalsIgnoreCase("s")) recur(mat, r, c + 1, check + 1, num + 1);
                    if (mat[r][c - 1].equalsIgnoreCase("s")) recur(mat, r, c - 1, check + 1, num + 1);
                    if (mat[r - 1][c].equalsIgnoreCase("s")) recur(mat, r - 1, c, check + 1, num + 1);
                    if (mat[r - 1][c + 1].equalsIgnoreCase("s")) recur(mat, r - 1, c + 1, check + 1, num + 1);
                    if (mat[r - 1][c - 1].equalsIgnoreCase("s")) recur(mat, r - 1, c - 1, check + 1, num + 1);
                    System.out.println("hi");
                } catch (IndexOutOfBoundsException e) {
                    if (r + 1 >= mat.length) {
                        if (c + 1 >= mat[0].length) {
                            if (mat[r][c - 1].equalsIgnoreCase("s")) recur(mat, r, c - 1, check + 1, num + 1);
                            if (mat[r - 1][c].equalsIgnoreCase("s")) recur(mat, r - 1, c, check + 1, num + 1);
                            if (mat[r - 1][c - 1].equalsIgnoreCase("s")) recur(mat, r - 1, c - 1, check + 1, num + 1);
                        } else if (c - 1 < 0) {
                            if (mat[r][c + 1].equalsIgnoreCase("s")) recur(mat, r, c + 1, check + 1, num + 1);
                            if (mat[r - 1][c].equalsIgnoreCase("s")) recur(mat, r - 1, c, check + 1, num + 1);
                            if (mat[r - 1][c + 1].equalsIgnoreCase("s")) recur(mat, r - 1, c + 1, check + 1, num + 1);
                        } else {
                            if (mat[r][c + 1].equalsIgnoreCase("s")) recur(mat, r, c + 1, check + 1, num + 1);
                            if (mat[r][c - 1].equalsIgnoreCase("s")) recur(mat, r, c - 1, check + 1, num + 1);
                            if (mat[r - 1][c].equalsIgnoreCase("s")) recur(mat, r - 1, c, check + 1, num + 1);
                            if (mat[r - 1][c + 1].equalsIgnoreCase("s")) recur(mat, r - 1, c + 1, check + 1, num + 1);
                            if (mat[r - 1][c - 1].equalsIgnoreCase("s")) recur(mat, r - 1, c - 1, check + 1, num + 1);
                        }
                    } else if (r - 1 < 0) {
                        if (c + 1 >= mat[0].length) {
                            if (mat[r + 1][c].equalsIgnoreCase("s")) recur(mat, r + 1, c, check + 1, num + 1);
                            if (mat[r + 1][c - 1].equalsIgnoreCase("s")) recur(mat, r + 1, c - 1, check + 1, num + 1);
                            if (mat[r][c - 1].equalsIgnoreCase("s")) recur(mat, r, c - 1, check + 1, num + 1);
                        } else if (c - 1 < 0) {
                            if (mat[r + 1][c].equalsIgnoreCase("s")) recur(mat, r + 1, c, check + 1, num + 1);
                            if (mat[r + 1][c + 1].equalsIgnoreCase("s")) recur(mat, r + 1, c + 1, check + 1, num + 1);
                            if (mat[r][c + 1].equalsIgnoreCase("s")) recur(mat, r, c + 1, check + 1, num + 1);
                        } else {
                            if (mat[r + 1][c].equalsIgnoreCase("s")) recur(mat, r + 1, c, check + 1, num + 1);
                            if (mat[r + 1][c + 1].equalsIgnoreCase("s")) recur(mat, r + 1, c + 1, check + 1, num + 1);
                            if (mat[r + 1][c - 1].equalsIgnoreCase("s")) recur(mat, r + 1, c - 1, check + 1, num + 1);
                            if (mat[r][c + 1].equalsIgnoreCase("s")) recur(mat, r, c + 1, check + 1, num + 1);
                            if (mat[r][c - 1].equalsIgnoreCase("s")) recur(mat, r, c - 1, check + 1, num + 1);
                        }
                    } else {
                        if (c + 1 >= mat[0].length) {
                            if (mat[r + 1][c].equalsIgnoreCase("s")) recur(mat, r + 1, c, check + 1, num + 1);
                            if (mat[r + 1][c - 1].equalsIgnoreCase("s")) recur(mat, r + 1, c - 1, check + 1, num + 1);
                            if (mat[r][c - 1].equalsIgnoreCase("s")) recur(mat, r, c - 1, check + 1, num + 1);
                            if (mat[r - 1][c].equalsIgnoreCase("s")) recur(mat, r - 1, c, check + 1, num + 1);
                            if (mat[r - 1][c - 1].equalsIgnoreCase("s")) recur(mat, r - 1, c - 1, check + 1, num + 1);
                            if (mat[r + 1][c].equalsIgnoreCase("-")) recur(mat, r + 1, c, check + 1, num);
                            if (mat[r + 1][c - 1].equalsIgnoreCase("-")) recur(mat, r + 1, c - 1, check + 1, num);
                        } else if (c - 1 < 0) {
                            if (mat[r + 1][c].equalsIgnoreCase("s")) recur(mat, r + 1, c, check + 1, num + 1);
                            if (mat[r + 1][c + 1].equalsIgnoreCase("s")) recur(mat, r + 1, c + 1, check + 1, num + 1);
                            if (mat[r][c + 1].equalsIgnoreCase("s")) recur(mat, r, c + 1, check + 1, num + 1);
                            if (mat[r - 1][c].equalsIgnoreCase("s")) recur(mat, r - 1, c, check + 1, num + 1);
                            if (mat[r - 1][c + 1].equalsIgnoreCase("s")) recur(mat, r - 1, c + 1, check + 1, num + 1);
                        }
                    }
                }


        return num;
    }

    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/2024-9a.txt"));
            var strs = new ArrayList<String>();
            while (input.hasNext()) {
                strs.add(input.nextLine());
            }
            var mat = new String[strs.size()][strs.get(0).length()];
            var r = 0;
            var c = 0;
            for (int l = 0; l < strs.size(); l++) {
                for(int lcv = 0 ; lcv < strs.get(l).length(); lcv++) {
                    mat[l][lcv] = strs.get(l).substring(lcv, lcv+1);
                    if (mat[l][lcv].equalsIgnoreCase(">")) {
                        r = l;
                        c = lcv;
                    }
                }
            }
            System.out.println(recur(mat, r, c, 0, 0));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
