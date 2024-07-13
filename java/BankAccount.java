import java.util.Scanner;

public class BankAccount {
    private int Acc_no, Balance;
    private char Acc_type;
    Scanner sc = new Scanner(System.in);

    BankAccount(int A, char TYPE, int B) {
        Acc_no = A;
        Acc_type = TYPE;
        Balance = B;
    }

    void BalanceInquiry() {
        System.out.println("Account No:" + Acc_no);
        System.out.println("Account Type:" + Acc_type);
        System.out.println("Account Balance:" + Balance);
    }

    void Deposit() {
        System.out.print("Deposit Amount=");
        int d = sc.nextInt();
        Balance += d;
        System.out.println("Amount Deposited.\nYour New Balance is = " + Balance);
    }

    void Withdraw() {
        System.out.print("Withdraw Amount=");
        int w = sc.nextInt();
        if (w > Balance) {
            System.out.println("Insufficient balance");
        } else {
            Balance -= w;
            System.out.println("Amount Withdrawn.\nYour New Balance is = " + Balance);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numAccounts = 1;
        BankAccount[] accounts = new BankAccount[numAccounts];
        do {
            System.out.println("1.Create Account\n2.Already Created:\n");
            int ch = scanner.nextInt();
            if (ch == 1) {
                int accNo;
                char accType;
                int initialBalance;
                System.out.print("Enter Account No: ");
                accNo = scanner.nextInt();
                System.out.print("Enter Account Type: ");
                accType = scanner.next().charAt(0);
                System.out.print("Enter Initial Balance: ");
                initialBalance = scanner.nextInt();
                accounts[0] = new BankAccount(accNo, accType, initialBalance);
            } else if (ch == 2) {
                int accountChoice;
                System.out.println("\nSelect an account (1-" + numAccounts + ") or enter 0 to exit:");
                accountChoice = scanner.nextInt();
                if (accountChoice == 0) {

                    break;

                }
                if (accountChoice < 1 || accountChoice > numAccounts) {
                    System.out.println("Invalid account number.");
                    break;
                }
                BankAccount selectedAccount = accounts[accountChoice - 1];

                int option;
                do {

                    System.out.println("\n1. Deposit\n2. Withdraw\n3. Balance Inquiry\n4. Exit");
                    System.out.print("Select an option for account " + selectedAccount.Acc_no + ": ");
                    option = scanner.nextInt();

                    switch (option) {
                        case 1:
                            selectedAccount.Deposit();
                            break;
                        case 2:
                            selectedAccount.Withdraw();
                            break;
                        case 3:
                            selectedAccount.BalanceInquiry();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                } while (option != 4);
                if (option == 4) {
                    break;
                }
                scanner.close();
            }
        } while (true);
    }
}
