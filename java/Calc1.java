import java.util.Scanner;

public class Calc1 {
    public static void main(String[] args) {
        double n1;
        double n2;
        double ans;
        char op;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter two numbers:");
            n1 = sc.nextDouble();
            n2 = sc.nextDouble();
            System.out.println("Enter the operator(+,-,*,/): ");
            op = sc.next().charAt(0);
            switch (op) {
                case '+':
                    ans = n1 + n2;
                    break;
                case '-':
                    ans = n1 - n2;
                    break;
                case '*':
                    ans = n1 * n2;
                    break;
                case '/':
                    ans = n1 / n2;
                    break;
                default:
                    System.out.println("\n Error! Enter correct operator");
                    return;
            }
            System.out.println("The result is:");
            System.out.printf(n1 + "" + op + "" + n2 + " = " + ans);
        }
    }
}