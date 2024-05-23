import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class QuizQuestion {
    String question;
    String[] options;
    String answer;

    QuizQuestion(String question, String[] options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
}
class QuizApp extends JFrame implements ActionListener {
    private static final int TIME_LIMIT = 10;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int timeRemaining = TIME_LIMIT;
    
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionsGroup;
    private JButton submitButton;
    private JLabel timerLabel;
    private Timer timer;
    
    private QuizQuestion[] quizQuestions = {
        new QuizQuestion("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, "Paris"),
        new QuizQuestion("Who wrote 'To Kill a Mockingbird'?", new String[]{"Harper Lee", "J.K. Rowling", "Ernest Hemingway", "Mark Twain"}, "Harper Lee"),
        new QuizQuestion("What is the largest mammal?", new String[]{"Elephant", "Giraffe", "Blue Whale", "Hippopotamus"}, "Blue Whale"),
        new QuizQuestion("Which planet is known as the 'Red Planet'?", new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, "Mars"),
        new QuizQuestion("What is the chemical symbol for gold?", new String[]{"Au", "Ag", "Fe", "Cu"}, "Au")
    };



    public QuizApp() {
        setTitle("Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        questionLabel = new JLabel("", JLabel.CENTER);
        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionsGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        timerLabel = new JLabel("Time remaining: " + TIME_LIMIT, JLabel.CENTER);

        setLayout(new BorderLayout());
        add(questionLabel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
        add(timerLabel, BorderLayout.EAST);

        loadQuestion();
        startTimer();

        setVisible(true);
    }

    private void loadQuestion() {
        if (currentQuestionIndex < quizQuestions.length) {
            QuizQuestion currentQuestion = quizQuestions[currentQuestionIndex];
            questionLabel.setText(currentQuestion.question);
            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(currentQuestion.options[i]);
                optionButtons[i].setSelected(false);
            }
            timeRemaining = TIME_LIMIT;
            timerLabel.setText("Time remaining: " + TIME_LIMIT);
        } else {
            showResults();
        }
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                timerLabel.setText("Time remaining: " + timeRemaining);
                if (timeRemaining <= 0) {
                    timer.stop();
                    checkAnswer();
                }
            }
        });
        timer.start();
    }

    private void checkAnswer() {
        String selectedOption = null;
        for (JRadioButton optionButton : optionButtons) {
            if (optionButton.isSelected()) {
                selectedOption = optionButton.getText();
                break;
            }
        }

        if (selectedOption != null && selectedOption.equals(quizQuestions[currentQuestionIndex].answer)) {
            score++;
        }

        currentQuestionIndex++;
        loadQuestion();
        startTimer();
    }

    private void showResults() {
        JOptionPane.showMessageDialog(this, "Quiz finished! Your score: " + score + "/" + quizQuestions.length);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
        checkAnswer();
    }
}

public class T4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizApp();
            }
        });
    }
}