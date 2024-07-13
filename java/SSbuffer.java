import java.util.Scanner;

public class SSbuffer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter another string: ");
        String str2 = scanner.nextLine();

        String concatString = str1 + " " + str2;
        System.out.println("Concatenated String: " + concatString);

        System.out.println("Length of str1: " + str1.length());

        System.out.print("Enter the index to access character in str2: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < str2.length()) {
            System.out.println("Character at index " + index + " in str2: " + str2.charAt(index));
        } else {
            System.out.println("Index out of bounds.");
        }

        System.out.print("Enter another string for comparison with str1: ");
        String str3 = scanner.next();
        System.out.println("Are str1 and str3 equal? " + str1.equals(str3));

        System.out.print("Enter a string for StringBuffer: ");
        String inputString = scanner.next();
        StringBuffer buffer = new StringBuffer(inputString);

        System.out.print("Enter text to append to StringBuffer: ");
        String appendString = scanner.next();
        buffer.append(appendString);
        System.out.println("Appended StringBuffer: " + buffer);

        System.out.print("Enter index to insert into StringBuffer: ");
        int insertIndex = scanner.nextInt();
        System.out.print("Enter text to insert into StringBuffer: ");
        String insertText = scanner.next();
        if (insertIndex >= 0 && insertIndex <= buffer.length()) {
            buffer.insert(insertIndex, insertText);
            System.out.println("Inserted StringBuffer: " + buffer);
        } else {
            System.out.println("Index out of bounds.");
        }

    }
}
