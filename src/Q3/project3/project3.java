package Q3.project3;

import Q3.CS161LabJ.LabJ.CalculatorGUI;

import javax.swing.*;

public class project3 {
    private JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public project3() {

    }


    public static void main(String[] args) {
        var frame = new JFrame("Student GPA");
        frame.setContentPane(new project3().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
