package Q3.CS161LabJ.LabJ;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static Utils.Console.print;

public class CalculatorGUI {
    private JPanel mainPanel;
    private JButton a7Button;
    private JButton cButton;
    private JButton a4Button;
    private JButton a1Button;
    private JButton a0Button;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton button9;
    private JButton a9Button;
    private JButton button11;
    private JButton a6Button;
    private JButton button13;
    private JButton a3Button;
    private JButton button15;
    private JButton button16;
    private JButton button17;
    private JLabel nums;

    public static double fnum = 0;
    public static double snum = 0;
    public static int operator;
    public static Calculator t;
    public static boolean decimal;
    public static int decilevel;

    public CalculatorGUI() {
        decilevel = 1;
        t = new Calculator();
        decimal = false;
        nums.setText("");
        cButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                t.clear();
                fnum = 0;
                snum = 0;
                operator = 0;
                nums.setText("");
                decimal = false;
                decilevel = 1;
            }
        });
        button15.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var str = nums.getText();

                var num = operate(str);
                nums.setText(String.valueOf(num));
                operator = 0;
            }
        });
        button9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                decimal = true;
                nums.setText(nums.getText() + ".");
            }
        });

                a0Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        nums.setText(nums.getText() + 0);
                    }
                });

                a1Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        nums.setText(nums.getText() + 1);
                    }
                });

                a2Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        nums.setText(nums.getText() + 2);
                    }
                });

                a3Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        nums.setText(nums.getText() + 3);
                    }
                });

                a4Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        nums.setText(nums.getText() + 4);
                    }
                });

                a5Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        nums.setText(nums.getText() + 5);
                    }
                });

                a6Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        nums.setText(nums.getText() + 6);
                    }
                });

                a7Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        nums.setText(nums.getText() + 7);
                    }
                });

                a8Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        nums.setText(nums.getText() + 8);
                    }
                });

                a9Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        nums.setText(nums.getText() + 9);
                    }
                });

                button11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 4;
                        System.out.println(operator);
                        nums.setText(nums.getText() + " / ");
                    }
                });
                button13.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 3;
                        nums.setText(nums.getText() + " * ");
                    }
                });
                button16.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 2;
                        nums.setText(nums.getText() + " - ");
                    }
                });
                button17.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 1;
                        nums.setText(nums.getText() + " + ");
                    }
                });


    }

    public static double operate(String str) {
        var symbols = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                symbols.add("+");
                str = str.substring(0, i) + " ? " + str.substring(i+1);
            }
            if (str.charAt(i) == '-') {
                symbols.add("-");
                str = str.substring(0, i) + " ? " + str.substring(i+1);
            }
            if (str.charAt(i) == '*') {
                symbols.add("*");
                str = str.substring(0, i) + " ? " + str.substring(i+1);
            }
            if (str.charAt(i) == '/') {
                symbols.add("/");
                str = str.substring(0, i) + " ? " + str.substring(i+1);
            }
        }
        var spl = str.split(" ? ");
        var d = new ArrayList<Double>();
        var t = new Calculator();
        for (int i = 0; i < spl.length; i++) {
            if (!spl[i].equals("?")) {
                d.add(Double.parseDouble(spl[i]));
            }
        }
        for (int i = 0; i < symbols.size(); i++) {
            var op = symbols.get(i);
            if (op.equals("/")) {
                t = new Calculator(d.remove(i), 4);
                symbols.remove(i);
                t.divide(d.remove(i));
                d.add(i, t.getValue());
                i--;
            } else if (op.equals("*")) {
                t = new Calculator(d.remove(i), 3);
                symbols.remove(i);
                t.multiply(d.remove(i));
                d.add(i, t.getValue());
                i--;
            }
        }
        for (int i = 0; i < symbols.size(); i++) {
            var op = symbols.get(i);
            if (op.equals("+")) {
                t = new Calculator(d.remove(i), 1);
                symbols.remove(i);
                t.add(d.remove(i));
                d.add(i, t.getValue());
                i--;
            } else if (op.equals("-")) {
                t = new Calculator(d.remove(i), 2);
                symbols.remove(i);
                t.subtract(d.remove(i));
                d.add(i, t.getValue());
                i--;
            }
        }

        return d.get(0);
    }

    public static void main(String[] args) {
        var frame = new JFrame("Calculator");
        frame.setContentPane(new CalculatorGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
