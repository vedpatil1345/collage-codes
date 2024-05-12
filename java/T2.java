import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Grades extends JFrame implements ActionListener {
    private JTextField Sci, Math, Eng;
    private JButton calculate;
    private JLabel res;

    public Grades() {
        super("Grade Calculator");
        setLayout(new GridLayout(5, 2, 5, 5));

        Sci = new JTextField(10);
        Math = new JTextField(10);
        Eng = new JTextField();
        calculate = new JButton("Calculate");
        res = new JLabel();
        calculate.addActionListener(this);
        add(new JLabel("Science:"));
        add(Sci);
        add(new JLabel("Mathamatics:"));
        add(Math);
        add(new JLabel("English:"));
        add(Eng);
        add(calculate);
        add(new JLabel("Result:"));
        add(res);
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int sci = Integer.parseInt(Sci.getText());
            int math = Integer.parseInt(Math.getText());
            int eng = Integer.parseInt(Eng.getText());

            int total = sci + math + eng;
            double per = total / 3;
            String grade;
            if (per >= 90) {
                grade = "A+";
            } else if (per >= 80) {
                grade = "A";
            } else if (per >= 70) {
                grade = "B+";
            } else if (per >= 60) {
                grade = "B";
            } else if (per >= 50) {
                grade = "C";
            } else if (per >= 33) {
                grade = "D";
            } else {
                grade = "F";
            }
            res.setText("Total:" + total + "        Percentage:" + per + "       Grade:" + grade);
        } catch (NumberFormatException ex) {
            res.setText("invalid input, enter numbers only.");
        }
    }
}

class T2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Grades::new);
    }
}