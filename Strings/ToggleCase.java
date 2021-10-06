package Strings;

public class ToggleCase {

    // Quesiton and Solution: https://www.youtube.com/watch?v=VQnWqpHpKnE

    // Convert uppercase characters to lowercase and vice versa

    public static void main(String[] args) {
        // For test
        // char inputString = 'a';
        // System.out.println((char)(inputString - 32));

        String str = "iLoveDataSTRUCTURes";
        StringBuilder sbr = new StringBuilder(str);
        int ct = 0;
        int len = str.length();

        while (ct < len) {
            char newChar = str.charAt(ct);
            if (newChar >= 'a' && newChar <= 'z') {
                sbr.setCharAt(ct, (char) (newChar - 32));
            } else {
                sbr.setCharAt(ct, (char) (newChar + 32));
            }

            ct++;
        }
        System.out.println(sbr.toString());

    }

}
