package Q1.pelican;

import javax.swing.text.NumberFormatter;
import java.io.*;
import java.util.*;
import java.text.*;

public class peli42_7and43_8 {
    public static class bankAccount {
        private String name;
        private double balan;
        public bankAccount(String nm, double amt){
            name = nm;
            balan = amt;
        }

        public void deposit(double dp){
            balan += dp;
        }
        public void withdraw(double wd) {
            balan -= wd;
        }

        public double getBalan() {
            return balan;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        String name;
        NumberFormat form = new DecimalFormat("$#,###.##");
        ArrayList<bankAccount> bank = new ArrayList<>();
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Pleases enter the name to whom the account belongs. (\"Exit\" to abort)");

            name = input.nextLine();

            if (!name.equalsIgnoreCase("EXIT"))  {
                System.out.println("Please enter the amount of the deposit. ");
                double amount = input.nextDouble();
                System.out.println();
                bankAccount newb = new bankAccount(name, amount);
                bank.add(newb);
            }
        }while(!name.equalsIgnoreCase("EXIT"));
        ListIterator<bankAccount> iter = bank.listIterator();
        bankAccount bf = iter.next();
        double maxba = bf.getBalan();
        String maxna = bf.getName();
        while (iter.hasNext()) {
            bankAccount temp = iter.next();
            if (maxba < temp.getBalan()) {
                maxba = temp.getBalan();
                maxna = temp.getName();
            }
        }
        System.out.println("The account with the largest balance belongs to " + maxna + ".");
        System.out.println("The amount is " + form.format(maxba));
    }
}
//Pleases enter the name to whom the account belongs. ("Exit" to abort)
//Jim Jones
//Please enter the amount of the deposit.
//186.22
//
//Pleases enter the name to whom the account belongs. ("Exit" to abort)
//Bill Gates
//Please enter the amount of the deposit.
//102.15
//
//Pleases enter the name to whom the account belongs. ("Exit" to abort)
//Helen Hunt
//Please enter the amount of the deposit.
//1034.02
//
//Pleases enter the name to whom the account belongs. ("Exit" to abort)
//Charles Manson
//Please enter the amount of the deposit.
//870.85
//
//Pleases enter the name to whom the account belongs. ("Exit" to abort)
//exit
//The account with the largest balance belongs to Helen Hunt.
//The amount is $1034.02

//Pleases enter the name to whom the account belongs. ("Exit" to abort)
//Jim Jones
//Please enter the amount of the deposit.
//186.22
//
//Pleases enter the name to whom the account belongs. ("Exit" to abort)
//Bill Gates
//Please enter the amount of the deposit.
//102.15
//
//Pleases enter the name to whom the account belongs. ("Exit" to abort)
//Helen Hunt
//Please enter the amount of the deposit.
//1034.02
//
//Pleases enter the name to whom the account belongs. ("Exit" to abort)
//Charles Manson
//Please enter the amount of the deposit.
//870.85
//
//Pleases enter the name to whom the account belongs. ("Exit" to abort)
//exit
//The account with the largest balance belongs to Helen Hunt.
//The amount is $1,034.02