package Q3.project3;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class project3 {

    private JTextField textField1;
    private JPanel panel1;
    private JButton addStudentButton;
    private JList<student> list1;
    private JLabel Organizer;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private static Map<String, student> list;

    private class student {
        private String name;
        private String[] grades = new String[4];
        private double gpa;

        public student(String name, String[] grades) {
            this.name = name;
            this.grades = grades;
            gpa = this.calc();
        }

        private double calc() {
            var nums = 0.0;
            var tot = 0.0;
            for (String str : grades) {
                if (!str.equalsIgnoreCase("N/A")) {
                    nums++;
                    tot += str.equalsIgnoreCase("A") ? 4.0 :
                            str.equalsIgnoreCase("B") ? 3.0 :
                                    str.equalsIgnoreCase("C") ? 2.0 :
                                            str.equalsIgnoreCase("D") ? 1.0 : 0.0;
                }
            }
            tot /= nums;
            return tot;
        }

        public String getName() {
            return name;
        }

        public double getGpa() {
            return gpa;
        }

        public String[] getGrades() {
            return grades;
        }
        public void setMath(String grade) {
            grades[0] = grade;
            gpa = this.calc();
        }
        public void setEnglish(String grade) {
            grades[1] = grade;
            gpa = this.calc();
        }
        public void setScience(String grade) {
            grades[2] = grade;
            gpa = this.calc();
        }
        public void setSocial(String grade) {
            grades[3] = grade;
            gpa = this.calc();
        }
        public String toString() {
            return "   " + name + "               " + grades[0] + "          " + grades[1] + "             " + grades[2] + "             " + grades[3] + "                                       " + gpa;
        }
    }

    public project3() {
        comboBox1.addItem("Math");
        comboBox1.addItem("English");
        comboBox1.addItem("Science");
        comboBox1.addItem("Social Studies");
        comboBox2.addItem("A");
        comboBox2.addItem("B");
        comboBox2.addItem("C");
        comboBox2.addItem("D");
        comboBox2.addItem("F");
        list = new HashMap<>();
        Organizer.setText("Student     Math     English     Science     Social Studies     GPA");
        addStudentButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var Student = textField1.getText();
                var subject = (String) comboBox1.getItemAt(comboBox1.getSelectedIndex());
                var Grade = (String) comboBox2.getItemAt(comboBox2.getSelectedIndex());
                if (list.containsKey(Student)) {
                    if (subject.equals("Math")) {
                        list.get(Student).setMath(Grade);
                    }
                    if (subject.equals("English")) {
                        list.get(Student).setEnglish(Grade);
                    }
                    if (subject.equals("Science")) {
                        list.get(Student).setScience(Grade);
                    }
                    if (subject.equals("Social Studies")) {
                        list.get(Student).setSocial(Grade);
                    }
                } else {
                    if (subject.equals("Math")) {
                        list.put(Student, new student(Student, new String[] {Grade, "N/A", "N/A", "N/A"}));
                    }
                    if (subject.equals("English")) {
                        list.put(Student, new student(Student, new String[] {"N/A", Grade, "N/A", "N/A"}));
                    }
                    if (subject.equals("Science")) {
                        list.put(Student, new student(Student, new String[] {"N/A", "N/A", Grade, "N/A"}));
                    }
                    if (subject.equals("Social Studies")) {
                        list.put(Student, new student(Student, new String[] {"N/A", "N/A", "N/A", Grade}));
                    }
                }
                list1.clearSelection();
                list1.setListData(list.values().toArray(new student[0]));
            }
        });
    }


    public static void main(String[] args) {
        var frame = new JFrame("Student GPA");
        frame.setContentPane(new project3().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
