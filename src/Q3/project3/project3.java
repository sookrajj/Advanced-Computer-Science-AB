package Q3.project3;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class project3 {

    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel panel1;
    private JButton addStudentButton;
    private JList<student> list1;
    private JScrollPane scroll;
    private JLabel Organizer;
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
                if (!str.equalsIgnoreCase("")) {
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
            return "   " + name + "               " + grades[0] + "          " + grades[1] + "             " + grades[2] + "             " + grades[3] + "                        " + gpa;
        }
    }

    public project3() {
        list = new HashMap<>();
        Organizer.setText("Student     Math     English     Science     Social Studies     GPA");
        addStudentButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var Student = textField1.getText();
                var subject = textField2.getText();
                var Grade = textField3.getText();
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
                        list.put(Student, new student(Student, new String[] {Grade, "", "", ""}));
                    }
                    if (subject.equals("English")) {
                        list.put(Student, new student(Student, new String[] {"", Grade, "", ""}));
                    }
                    if (subject.equals("Science")) {
                        list.put(Student, new student(Student, new String[] {"", "", Grade, ""}));
                    }
                    if (subject.equals("Social Studies")) {
                        list.put(Student, new student(Student, new String[] {"", "", "", Grade}));
                    }
                }
                list1.clearSelection();
                list1.setListData(list.values().toArray(new student[0]));
                textField2.setText("");
                textField3.setText("");
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
