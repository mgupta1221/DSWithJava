package PepLevelUp.RecursionTree;

public class SendMoreMoney_LC1307 {

    // TODO - not complete
    private static int SolveSendMoney(String superString, int idx) {
        if (idx == superString.length()) {
            return 1;
        }
        boolean[] isNumUsed = new boolean[10];
        int count = 0;
        for (int i = 0; i <= 9; i++) {
            if (!isNumUsed[i]) {
                isNumUsed[i] = true;
                count += SolveSendMoney(superString, idx + 1);
                isNumUsed[i] = false;

            }

        }

        return 0;
    }

    private static boolean SolveSendMoneyHelper(String[] str, String RHS_String) {
        String superString = "";
        for (String s : str) {
            superString += s;
        }
        superString += RHS_String;// adding result string too

        int[] freq = new int[26];
        // Below for loop with store the occurences count of charcters in a string in
        // freq[] array in alphabetical order
        // e.g. "sendmoremoney" will store [0,0,0,0,3.....] 3 because 'e' occured 3
        // times
        for (int i = 0; i < superString.length(); i++) {
            freq[superString.charAt(i) - 'a']++;
        }
        superString = "";
        // Below For loop will remove the duplicate values and order them alphabetically
        // "demnorsy"
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                superString += (char) (i + 'a');
            }
        }
        System.out.println(superString);

        if (superString.length() > 10) {
            return false;
        }

        return false;
        // return SolveSendMoney(superString, 0);

    }

    public static void main(String[] args) {

        String[] words = { "send", "more" };
        String money = "money";
        SolveSendMoneyHelper(words, money);

    }
}
