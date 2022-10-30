package StriverSheet.Day9_Recursion.Basics;

public class Problems1 {

    public static boolean StringPallendrome(String str, int m, int n) {

        if (str.length() <= 0 || m > n) {
            return true;
        }

        char ch1 = str.charAt(m);
        char ch2 = str.charAt(n);
        if (ch1 != ch2) {
            return false;
        }
        return StringPallendrome(str, m + 1, n - 1);

    }

    public static void main(String[] args) {
        boolean result = StringPallendrome("NITIN",0, 4);
        System.out.println(result);
    }
}
