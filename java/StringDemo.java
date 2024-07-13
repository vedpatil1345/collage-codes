public class StringDemo {
    public static void main(String[] args) {
        // String class demonstration
        String str = "Hello";
        System.out.println("Original String: " + str);

        // Concatenation
        str = str + " World!";
        System.out.println("Concatenated String: " + str);

        // Length
        int length = str.length();
        System.out.println("Length of String: " + length);

        // Substring
        String subStr = str.substring(6);
        System.out.println("Substring: " + subStr);

        // Character at index
        char charAt3 = str.charAt(3);
        System.out.println("Character at index 3: " + charAt3);

        // Index of
        int index = str.indexOf("World");
        System.out.println("Index of 'World': " + index);

        // String comparison
        String str2 = "hello world!";
        System.out.println("Comparison with 'hello world!': " + str.equalsIgnoreCase(str2));

        // StringBuffer class demonstration
        StringBuffer stringBuffer = new StringBuffer("Hello");
        System.out.println("\nOriginal StringBuffer: " + stringBuffer);

        // Append
        stringBuffer.append(" World!");
        System.out.println("Appended StringBuffer: " + stringBuffer);

        // Length
        int bufferLength = stringBuffer.length();
        System.out.println("Length of StringBuffer: " + bufferLength);

        // Insert
        stringBuffer.insert(5, "Awesome ");
        System.out.println("Inserted StringBuffer: " + stringBuffer);

        // Reverse
        stringBuffer.reverse();
        System.out.println("Reversed StringBuffer: " + stringBuffer);
    }
}
