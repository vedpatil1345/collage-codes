public class WrapperDemo {
    public static void main(String[] args) {

        Integer intObj = Integer.valueOf(100);
        Double doubleObj = Double.valueOf(3.14);
        Character charObj = Character.valueOf('A');
        Boolean booleanObj = Boolean.valueOf(true);

        System.out.println("Integer Object: " + intObj);
        System.out.println("Double Object: " + doubleObj);
        System.out.println("Character Object: " + charObj);
        System.out.println("Boolean Object: " + booleanObj);

        int intValue = intObj.intValue();
        double doubleValue = doubleObj.doubleValue();
        char charValue = charObj.charValue();
        boolean booleanValue = booleanObj.booleanValue();

        System.out.println("\nPrimitive int value: " + intValue);
        System.out.println("Primitive double value: " + doubleValue);
        System.out.println("Primitive char value: " + charValue);
        System.out.println("Primitive boolean value: " + booleanValue);

        int parseIntResult = Integer.parseInt("123");
        double parseDoubleResult = Double.parseDouble("3.14");
        boolean parseBooleanResult = Boolean.parseBoolean("true");

        System.out.println("\nParsed int value: " + parseIntResult);
        System.out.println("Parsed double value: " + parseDoubleResult);
        System.out.println("Parsed boolean value: " + parseBooleanResult);

        System.out.println("\nMax value of Integer: " + Integer.MAX_VALUE);
        System.out.println("Min value of Integer: " + Integer.MIN_VALUE);
        System.out.println("Size of Integer: " + Integer.SIZE);
        System.out.println("Size of Double: " + Double.SIZE);
    }
}
