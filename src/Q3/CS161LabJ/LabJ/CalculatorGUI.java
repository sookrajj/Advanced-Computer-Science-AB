package Q3.CS161LabJ.LabJ;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

    public static int fnum = 0;
    public static int operator;
    public static Calculator t;

    public CalculatorGUI() {
        t = new Calculator();
        nums.setText("");
        button9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                t = new Calculator(0, 0);
            }
        });
        button15.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                t.applyOperation(fnum, operator);
            }
        });
        if (operator == 0) {
            a0Button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (fnum == 0) {

                    } else if (fnum % 10 == 0) {
                        fnum *= 10;
                    }
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
                }
            });

            a3Button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (fnum == 0) {
                        fnum += 3;
                    } else{
                        fnum *= 10;
                        fnum += 3;
                    }
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
                }
            });

            a8Button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (fnum == 0) {
                        fnum += 8;
                    } else{
                        fnum *= 10;
                        fnum += 8;
                    }
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
                }
            });

            button11.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    operator = 4;
                }
            });
            button13.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    operator = 3;
                }
            });
            button16.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    operator = 2;
                }
            });
            button17.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    operator = 1;
                }
            });
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
