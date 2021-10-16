package RecursionAndBacktracking.RecursionOnWayUp;

// https://www.youtube.com/watch?v=Ke8TPhHdHMw

// //For "abc"
//Expected Output  : "", "a", "b", "c", "ab", "ac", "bc, "abc" 
public class PrintSubSequence {   
    public static void main(String[] args) {
        String str = "678";
        printKPC(str, "");

    }

    public static void printKPC(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0); // first character
        String ros = str.substring(1); // rest of the string

        // recursive calls
        printKPC(ros, ans + "");
        printKPC(ros, ans + ch);

    }

}
