package RecursionAndBacktracking.RecursionOnWayUp;

// this question is similar to GetKeyPressCombination in "Recursion WithArraysLists" section
// there we were returning the values using ArrayList but here we have to print them

// Key is that we have taken an extra parameter in the function called 'ans' to calculate the KeyCombination
// in each iteration and printing it at Base Condition 

// Solution  : https://www.youtube.com/watch?v=Ke8TPhHdHMw
public class PrintKPC {
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
