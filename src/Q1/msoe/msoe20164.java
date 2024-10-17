package Q1.msoe;

import java.util.*;

public class msoe20164 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Number to put into Euler's function: ");
        var num = input.nextInt();
        var facts = new int[50][2];
        for (int lcv = 0; lcv < facts.length; lcv++) {
            facts[lcv][0] = 0;
            facts[lcv][1] = 0;
        }
        int checks = 2;
        var hi = false;
        while (num != 1) {
            if (num%checks == 0) {
                if (facts[0][0] == 0) {
                    facts[0][0] = checks;
                    facts[0][1] = 1;
                } else {
                    for (int lcv = 0; lcv < facts.length; lcv++) {
                        if (facts[lcv][0] == checks) {
                            hi = true;
                            facts[lcv][1]++;
                            System.out.println(checks);
                            break;
                        }
                    }
                    if (!hi) {
                        for (int lcv = 0; lcv < facts.length; lcv++) {
                            if (facts[lcv][0] == 0) {
                                facts[lcv][0] = checks;
                                facts[lcv][1]++;
                                break;
                            }
                        }
                    }
                    hi = false;
                }
                num = num/checks;
            } else {
                checks++;
            }
        }

        var tot = 1;
        for (int lcv = 0; lcv < facts.length; lcv++) {
            if (facts[lcv][0] != 0) {
                tot *= Math.pow(facts[lcv][0], facts[lcv][1]-1) * facts[lcv][0]-1;
            }
        }
        System.out.println("The total of Euler's function is: " + tot);
    }
}
