package AdobeQues;

import java.util.ArrayList;
import java.util.List;

// NEW
// https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1

// Apporoach : Recusrive with maintaining count of Open and close brackets in calls
// Solve with 2 types of recursive calls - logic is same

// Imp: Notice the 2 if conditions
//

public class GenerateParenthesis {

    // Aproach 1:
    public static List<String> AllParenthesis(int n) {
        ArrayList<String> al = new ArrayList<String>();
        AllParenthesis_helper(al, 0, 0, "", n);
        return al;
    }

    public static void AllParenthesis_helper(ArrayList<String> al, int open, int close, String str, int len) {
        if (open == len && close == len) {
            al.add(str);
            return;
        }
        // Notice this if condition open<n
        if (open < len) {
            AllParenthesis_helper(al, open + 1, close, str + "(", len);
        }
        // Notice this if condition close<open
        if (close < open) {
            AllParenthesis_helper(al, open, close + 1, str + ")", len);
        }
    }

    // Aproach 2:
    public List<String> AllParenthesis_appraoch2(int n) {
        // Write your code here
        List<String> ans = new ArrayList<>();
        genrate("", ans, n, n, n);
        return ans;

    }

    public static void genrate(String p, List<String> ans, int n, int open, int close) {
        if (open > close || open < 0 || close < 0) {
            return;
        }
        if (open == 0 && close == 0) {
            ans.add(p);
            return;
        }
        genrate(p + '(', ans, n, open - 1, close);
        genrate(p + ')', ans, n, open, close - 1);
    }

    public static void main(String[] args) {

        List<String> result = AllParenthesis(3);

        for (String string : result) {
            System.out.println(string);
        }
    }

}
