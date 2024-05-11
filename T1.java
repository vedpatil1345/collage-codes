import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class GuessTheNumber extends JFrame implements ActionListener {
    private static final int MAX_SCORE = 100;
    private JTextField guessField;
    private JButton guessButton;
    private JLabel msgLabel;
    private int targetNumber;
    private int score = MAX_SCORE;
    private int attempts = 0;

    public GuessTheNumber() {
        super("Guess The Number");
        setLayout(new FlowLayout());
        guessField = new JTextField(10);
        guessButton = new JButton("Guess");
        msgLabel = new JLabel("Enter your guess (1-100):");
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;
        guessButton.addActionListener(this);
        add(msgLabel);
        add(guessField);
        add(guessButton);

        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            int userGuess;
            try {
                userGuess = Integer.parseInt(guessField.getText());
            } catch (NumberFormatException ex) {
                msgLabel.setText("Enter a valid number");
                return;
            }

            attempts++;

            if (userGuess == targetNumber) {
                score -= attempts;
                msgLabel.setText(
                        "Congratulations! You guessed the number in " + attempts + " attempts. Your score: " + score);
                guessField.setEditable(false);
                guessButton.setEnabled(false);
            } else if (Math.abs(userGuess - targetNumber) <= 10) {
                msgLabel.setText(userGuess < targetNumber ? "A little low! Try again." : "A little high! Try again.");
            } else if (userGuess < targetNumber) {
                msgLabel.setText("Too low! Try again.");
            } else {
                msgLabel.setText("Too high! Try again.");
            }
        }
    }
}

public class T1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuessTheNumber::new);
    }
}