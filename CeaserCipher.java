package ceasercipher;

public class CeaserCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String text = "hello world";
        String encryptedText = CeaserCipher.encrypt(text, 4);
        String decryptedText = CeaserCipher.decrypt(encryptedText, 4);
        System.out.println("Encrypt: " + encryptedText);
        System.out.println("Encrypt: " + decryptedText);
    }

    public static String encrypt(String text, int s) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            char ch = ' ';
            if (!Character.isWhitespace(text.charAt(i))) {

                if (Character.isUpperCase(text.charAt(i))) {
                    ch = (char) (((int) text.charAt(i) + s - 65) % 26 + 65);

                } else {
                    ch = (char) (((int) text.charAt(i) + s - 97) % 26 + 97);

                }
            }

            result.append(ch);
        }
        return result.toString();
    }

    public static String decrypt(String cipher, int s) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < cipher.length(); i++) {
            char ch = ' ';
            int charDec = 0;
            if (!Character.isWhitespace(cipher.charAt(i))) {

                if (Character.isUpperCase(cipher.charAt(i))) {
                    charDec = ((int) cipher.charAt(i) - s - 65) % 26 + 65;
                    ch = (char) charDec;

                } else {
                    charDec = ((int) (cipher.charAt(i) - s) - 97) % 26 + 97;
                    ch = (char) (charDec);

                }
            }

            System.out.println("ch: " + cipher.charAt(i) + " dec: " + charDec);
            result.append(ch);
        }
        return result.toString();
    }
}
