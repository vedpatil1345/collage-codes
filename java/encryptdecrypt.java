import java.util.Scanner;

class Cipher {
    private String plainText;
    private int key;

    Cipher(String plainText, int key) {
        this.plainText = plainText;
        this.key = key;
    }

    public String encryption() {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);
            char encryptedChar = (char) (currentChar + key);
            encryptedText.append(encryptedChar);
        }
        return encryptedText.toString();
    }

    public String decryption() {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = encryption().charAt(i);
            char decryptedChar = (char) (currentChar - key);
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }

}

class encryptdecrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plain text: ");
        String plainText = scanner.nextLine();

        System.out.print("Enter the key: ");
        int key = scanner.nextInt();

        Cipher cipher = new Cipher(plainText, key);

        String encryptedText = cipher.encryption();
        System.out.println("Encrypted text: " + encryptedText);

        String decryptedText = cipher.decryption();
        System.out.println("Decrypted text: " + decryptedText);
    }
}
