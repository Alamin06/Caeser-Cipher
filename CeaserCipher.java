package ceasercipher;

import javax.swing.JOptionPane;

public class CeaserCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Encryption and decryption of Hello world
        String text = "Hello world";
        int shiftCount = 4;
        String encrypt = CeaserCipher.make(shiftCount, 0, 0, text);
        String decrypt = CeaserCipher.make(shiftCount, 1, 0, encrypt);
        System.out.println("Plain text: "+ text);
        System.out.println("Encrypted text: "+ encrypt);
        System.out.println("Decrypted text: "+ decrypt);
        
    }
    
    public static String make(int shiftcount, int operation, int language, String text){
        String result;
        if ( operation == 0 ) result = CeaserCipher.encrypt(text,shiftcount);
        else result = CeaserCipher.decrypt(text, shiftcount);
        return result;
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
                   
                    if(cipher.charAt(i) == 'a') {
                        charDec = ((int) (cipher.charAt(i) +  26 - s));
                    } else {
                        
                        charDec = ((int) (cipher.charAt(i) -  s - 97)) % 26 + 97;
                    }
                
                    ch = (char) (charDec);

                }
            }

            result.append(ch);
        }
        return result.toString();
    }
}
