import java.util.Scanner;

public class Wrapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer value: ");
        int intValue = scanner.nextInt();
        System.out.print("Enter a double value: ");
        double doubleValue = scanner.nextDouble();
        System.out.print("Enter a character value: ");
        char charValue = scanner.next().charAt(0);
        System.out.print("Enter a boolean value (true/false): ");
        boolean boolValue = scanner.nextBoolean();

        Integer intObj = Integer.valueOf(intValue);
        Double doubleObj = Double.valueOf(doubleValue);
        Character charObj = Character.valueOf(charValue);
        Boolean boolObj = Boolean.valueOf(boolValue);

        System.out.println("Integer value: " + intObj);
        System.out.println("Double value: " + doubleObj);
        System.out.println("Character value: " + charObj);
        System.out.println("Boolean value: " + boolObj);

        scanner.close();
    }
}
