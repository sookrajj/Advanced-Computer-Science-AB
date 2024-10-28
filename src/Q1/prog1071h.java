package Q1;

import DataStructures.QueueStack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prog1071h {
    public static class filler {
        private String type;
        private Double hours;
        private Integer code;

        public filler(String type, Double hours, Integer code) {
            this.type = type; this.hours = hours; this.code = code;
        }

        public Double getHours() {
            return hours;
        }

        public String getType() {
            return type;
        }

        public Integer getCode() {
            return code;
        }
    }
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/bgivntry.dat"));
            var type = new QueueStack<String>();
            var number = new QueueStack<Integer>();
            var value = new QueueStack<Double>();

            while (input.hasNext()) {
                type.push(input.next());
                number.push(input.nextInt());
                value.push(input.nextDouble());
                System.out.println(type.peek() + " " + number.peek() + " " + value.peek());
            }
            input.close();

            input = new Scanner(new File("Langdat/buysell.dat"));
            while (input.hasNext()) {
                type.push(input.next());
                number.push(input.nextInt());
                value.push(input.nextDouble());
                System.out.println(type.peek() + " " + number.peek() + " " + value.peek());
            }
            input.close();


        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
