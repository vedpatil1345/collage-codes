import java.util.*;

class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String s) {
        super(s);
    }
}

class Bank {
    private double balance;

    Bank(double q) {
        balance = q;
    }

    void Deposit(double x) {
        System.out.println("Old Balance = " + balance + "\nNew Balance = " + (balance + x));
        balance += x;
        System.out.println("Amount deposited:" + x);
    }

    void Withdraw(double y) throws ArithmeticException, NotEnoughMoneyException {
        if (balance < y)
            throw new NotEnoughMoneyException("Insufficient Balance.");
        else {
            if (balance - y < 500 && balance - y > 0) {
                throw new NotEnoughMoneyException("balance is too low." + "Please keep at least 500Rs in your account"
                        + "\n\"After withdrawal your remaining balance should be at least 500 rs\"");
            } else {
                System.out.println("Withdrawn Amount=" + y);
                System.out.println("Old Balance = " + balance + "\nNew Balance = " + (balance - y));
                balance -= y;
            }
        }
    }
}

public class TestBankClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial amount:");
        double init_amount = scanner.nextDouble();
        Bank b1 = new Bank(init_amount);
        int choice;
        do {
            System.out.println("\nMenu:\n1.Deposit\n2.Withdrawal\n3.Exit");
            System.out.print("Enter your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to be deposited:");
                    double dep_amount = scanner.nextDouble();
                    b1.Deposit(dep_amount);
                    break;
                case 2:
                    System.out.print("Enter the amount to be withdrawn:");
                    double withdraw_amount = scanner.nextDouble();
                    try {
                        b1.Withdraw(withdraw_amount);
                    } catch (ArithmeticException e) {
                        System.out.println("Caught an exception: " + e.getMessage());
                    } catch (NotEnoughMoneyException e) {
                        System.out.println("Caught another exception: " + e.getMessage());
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 3);
    }
}