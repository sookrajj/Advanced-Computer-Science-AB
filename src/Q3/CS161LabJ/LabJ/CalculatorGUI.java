package Q3.CS161LabJ.LabJ;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
                System.out.println(snum);
                var num = t.applyOperation(snum, operator);
                System.out.println(fnum + " " + snum + " " + operator + " " + num);
                nums.setText(String.valueOf(num));
                operator = 0;
            }
        });
        button9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                decimal = true;
                nums.setText(String.valueOf(Double.parseDouble(nums.getText())));
            }
        });
        if (!decimal) {
            if (operator == 0) {
                a0Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (fnum % 10 == 0) {
                            fnum *= 10;
                        }
                        System.out.println(operator);
                        nums.setText(nums.getText() + 0);
                    }
                });

                a1Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (fnum == 0) {
                            fnum += 1;
                        } else if (fnum % 10 == 0) {
                            fnum *= 10;
                            fnum += 1;
                        }
                        nums.setText(nums.getText() + 1);
                    }
                });

                a2Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (fnum == 0) {
                            fnum += 2;
                        } else {
                            fnum *= 10;
                            fnum += 2;
                        }
                        nums.setText(nums.getText() + 2);
                    }
                });

                a3Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (fnum == 0) {
                            fnum += 3;
                        } else {
                            fnum *= 10;
                            fnum += 3;
                        }
                        nums.setText(nums.getText() + 3);
                    }
                });

                a4Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (fnum == 0) {
                            fnum += 4;
                        } else {
                            fnum *= 10;
                            fnum += 4;
                        }
                        nums.setText(nums.getText() + 4);
                    }
                });

                a5Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (fnum == 0) {
                            fnum += 5;
                        } else if (fnum % 10 == 0) {
                            fnum *= 10;
                            fnum += 5;
                        }
                        nums.setText(nums.getText() + 5);
                    }
                });

                a6Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (fnum == 0) {
                            fnum += 6;
                        } else if (fnum % 10 == 0) {
                            fnum *= 10;
                            fnum += 6;
                        }
                        nums.setText(nums.getText() + 6);
                    }
                });

                a7Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (fnum == 0) {
                            fnum += 7;
                        } else {
                            fnum *= 10;
                            fnum += 7;
                        }
                        nums.setText(nums.getText() + 7);
                    }
                });

                a8Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (fnum == 0) {
                            fnum += 8;
                        } else {
                            fnum *= 10;
                            fnum += 8;
                        }
                        nums.setText(nums.getText() + 8);
                    }
                });

                a9Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (fnum == 0) {
                            fnum += 9;
                        } else {
                            fnum *= 10;
                            fnum += 9;
                        }
                        nums.setText(nums.getText() + 9);
                    }
                });

                button11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 4;
                        t = new Calculator(fnum, operator);
                        System.out.println(operator);
                        nums.setText(nums.getText() + "/");
                    }
                });
                button13.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 3;
                        t = new Calculator(fnum, operator);
                        nums.setText(nums.getText() + "*");
                    }
                });
                button16.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 2;
                        t = new Calculator(fnum, operator);
                        nums.setText(nums.getText() + "-");
                    }
                });
                button17.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 1;
                        t = new Calculator(fnum, operator);
                        System.out.println(operator);
                        nums.setText(nums.getText() + "+");
                    }
                });
            } else {
                a0Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (snum == 0) {

                        } else if (snum % 10 == 0) {
                            snum *= 10;
                        }
                        nums.setText(nums.getText() + 0);
                    }
                });

                a1Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (snum == 0) {
                            snum += 1;
                        } else if (snum % 10 == 0) {
                            snum *= 10;
                            snum += 1;
                        }
                        System.out.println(snum);
                        nums.setText(nums.getText() + 1);
                    }
                });

                a2Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (snum == 0) {
                            snum += 2;
                        } else {
                            snum *= 10;
                            snum += 2;
                        }
                        System.out.println(snum);
                        nums.setText(nums.getText() + 2);
                    }
                });

                a3Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (snum == 0) {
                            snum += 3;
                        } else {
                            snum *= 10;
                            snum += 3;
                        }
                        nums.setText(nums.getText() + 3);
                    }
                });

                a4Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (snum == 0) {
                            snum += 4;
                        } else {
                            snum *= 10;
                            snum += 4;
                        }
                        nums.setText(nums.getText() + 4);
                    }
                });

                a5Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (snum == 0) {
                            snum += 5;
                        } else if (snum % 10 == 0) {
                            snum *= 10;
                            snum += 5;
                        }
                        nums.setText(nums.getText() + 5);
                    }
                });

                a6Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (snum == 0) {
                            snum += 6;
                        } else if (snum % 10 == 0) {
                            snum *= 10;
                            snum += 6;
                        }
                        nums.setText(nums.getText() + 6);
                    }
                });

                a7Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (snum == 0) {
                            snum += 7;
                        } else {
                            snum *= 10;
                            snum += 7;
                        }
                        nums.setText(nums.getText() + 7);
                    }
                });

                a8Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (snum == 0) {
                            snum += 8;
                        } else {
                            snum *= 10;
                            snum += 8;
                        }
                        nums.setText(nums.getText() + 8);
                    }
                });

                a9Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (snum == 0) {
                            snum += 9;
                        } else {
                            snum *= 10;
                            snum += 9;
                        }
                        nums.setText(nums.getText() + 9);
                    }
                });

                button11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 4;
                        nums.setText(nums.getText() + "/");
                    }
                });
                button13.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 3;
                        nums.setText(nums.getText() + "*");
                    }
                });
                button16.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 2;
                        nums.setText(nums.getText() + "-");
                    }
                });
                button17.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 1;
                        nums.setText(nums.getText() + "+");
                    }
                });
            }
        } else {
            if (operator == 0) {
                a0Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        decilevel++;
                        nums.setText(nums.getText() + 0);
                    }
                });

                a1Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        fnum += Math.pow(10, -decilevel) * 1;
                        nums.setText(nums.getText() + 1);
                    }
                });

                a2Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        fnum += Math.pow(10, -decilevel) * 2;
                        nums.setText(nums.getText() + 2);
                    }
                });

                a3Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        fnum += Math.pow(10, -decilevel) * 3;
                        nums.setText(nums.getText() + 3);
                    }
                });

                a4Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        fnum += Math.pow(10, -decilevel) * 4;
                        nums.setText(nums.getText() + 4);
                    }
                });

                a5Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        fnum += Math.pow(10, -decilevel) * 5;
                        nums.setText(nums.getText() + 5);
                    }
                });

                a6Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        fnum += Math.pow(10, -decilevel) * 6;
                        nums.setText(nums.getText() + 6);
                    }
                });

                a7Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        fnum += Math.pow(10, -decilevel) * 7;
                        nums.setText(nums.getText() + 7);
                    }
                });

                a8Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        fnum += Math.pow(10, -decilevel) * 8;
                        nums.setText(nums.getText() + 8);
                    }
                });

                a9Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        fnum += Math.pow(10, -decilevel) * 9;
                        nums.setText(nums.getText() + 9);
                    }
                });

                button11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 4;
                        t = new Calculator(fnum, operator);
                        nums.setText(nums.getText() + "/");
                    }
                });
                button13.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 3;
                        t = new Calculator(fnum, operator);
                        nums.setText(nums.getText() + "*");
                    }
                });
                button16.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 2;
                        t = new Calculator(fnum, operator);
                        nums.setText(nums.getText() + "-");
                    }
                });
                button17.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 1;
                        t = new Calculator(fnum, operator);
                        nums.setText(nums.getText() + "+");
                    }
                });
            } else {
                a0Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        decilevel++;
                        nums.setText(nums.getText() + 0);
                    }
                });

                a1Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        snum += Math.pow(10, -decilevel) * 1;
                        nums.setText(nums.getText() + 1);
                    }
                });

                a2Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        snum += Math.pow(10, -decilevel) * 2;
                        nums.setText(nums.getText() + 2);
                    }
                });

                a3Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        snum += Math.pow(10, -decilevel) * 3;
                        nums.setText(nums.getText() + 3);
                    }
                });

                a4Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        snum += Math.pow(10, -decilevel) * 4;
                        nums.setText(nums.getText() + 4);
                    }
                });

                a5Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        snum += Math.pow(10, -decilevel) * 5;
                        nums.setText(nums.getText() + 5);
                    }
                });

                a6Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        snum += Math.pow(10, -decilevel) * 6;
                        nums.setText(nums.getText() + 6);
                    }
                });

                a7Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        snum += Math.pow(10, -decilevel) * 7;
                        nums.setText(nums.getText() + 7);
                    }
                });

                a8Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        snum += Math.pow(10, -decilevel) * 8;
                        nums.setText(nums.getText() + 8);
                    }
                });

                a9Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        snum += Math.pow(10, -decilevel) * 9;
                        nums.setText(nums.getText() + 9);
                    }
                });

                button11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 4;
                        nums.setText(nums.getText() + "/");
                    }
                });
                button13.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 3;
                        nums.setText(nums.getText() + "*");
                    }
                });
                button16.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 2;
                        nums.setText(nums.getText() + "-");
                    }
                });
                button17.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        operator = 1;
                        nums.setText(nums.getText() + "+");
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        var frame = new JFrame("Calculator");
        frame.setContentPane(new CalculatorGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
