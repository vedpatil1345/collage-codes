import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

class ATMGUI extends JFrame {
    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;

    public ATMGUI(double initialBalance) {
        account = new BankAccount(initialBalance);
        setTitle("ATM Machine");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        JLabel welcomeLabel = new JLabel("Welcome to the ATM");
        panel.add(welcomeLabel);
        balanceLabel = new JLabel("Current Balance: $" + formatAmount(account.getBalance()));
        panel.add(balanceLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        amountField = new JTextField();
        inputPanel.add(amountField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new WithdrawActionListener());
        buttonPanel.add(withdrawButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new DepositActionListener());
        buttonPanel.add(depositButton);

        inputPanel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(inputPanel);

        add(panel, BorderLayout.CENTER);
    }

    private void withdraw() {
        double amount;
        try {
            amount = Double.parseDouble(amountField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (amount <= 0) {
            JOptionPane.showMessageDialog(this, "Please enter a positive amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (account.getBalance() < amount) {
            JOptionPane.showMessageDialog(this, "Insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        account.withdraw(amount);
        balanceLabel.setText("Current Balance: $" + formatAmount(account.getBalance()));
        amountField.setText("");
    }

    private void deposit() {
        double amount;
        try {
            amount = Double.parseDouble(amountField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (amount <= 0) {
            JOptionPane.showMessageDialog(this, "Please enter a positive amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        account.deposit(amount);
        balanceLabel.setText("Current Balance: $" + formatAmount(account.getBalance()));
        amountField.setText("");
    }

    private String formatAmount(double amount) {
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        return formatter.format(amount);
    }

    private class WithdrawActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            withdraw();
        }
    }

    private class DepositActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            deposit();
        }
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

class T3 {
    public static void main(String[] args) {
        double initialBalance = 0;
        try {
            initialBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter your initial balance:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Using default balance of 0.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        ATMGUI atmGUI = new ATMGUI(initialBalance);
        atmGUI.setVisible(true);
    }
}
