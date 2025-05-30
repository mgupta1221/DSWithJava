package StriverSheet.Day16_StringII;

//LC 38: https://leetcode.com/problems/count-and-say/

// Approach 1: Using recursion (Self written)
// Approach 2: Shorter approach 

public class CountAndSay {

    public static String countAndSay(int n) {
        return countAndSayHelper(Integer.toString(n));
    }

    public static String countAndSayHelper(String n) {
        if (n.equals("1"))
            return "1";

        int num = Integer.parseInt(n);

        String tempResult = countAndSayHelper(Integer.toString(num - 1));

        // this below function will convert "1" -> "11", "21" -> '1211',
        // 411->'1421'...like that
        return StringCalc_WithInts(tempResult);
    }

    // This is the logic, but causes overflow so I write another one with String
    // below.
    // For logic understanding - use this one
    public static String StringCalc_WithInts(String tempResult) {
        // letter count we have to use as it was not reading the left-most digit so put
        // a check on while loop to read the left most digit
        int letterCount = tempResult.length();
        String result = "";
        int counter = 0;
        int currentDigit = 0;
        int lastDigit = 0;
        int tempNum = Integer.parseInt(tempResult);
        while (tempNum != 0 || letterCount >= -1) {

            // Get one digit at a time from right
            currentDigit = tempNum % 10;

            // keep increasing counter till last and current digit are sme
            if (currentDigit == lastDigit || lastDigit == 0) {
                counter++;
            } else {
                result = Integer.toString(counter) + lastDigit + result;
                counter = 1;
            }
            // update last digit with current digit for next iteration
            lastDigit = currentDigit;
            letterCount--;
            // drop the right-most digit
            tempNum = tempNum / 10;
        }
        return result;
    }

    // To avoid overflow, we used String here
    public static String StringCalc_withString(String tempResult) {
        int letterCount = tempResult.length();
        String result = "";
        int counter = 0;
        int currentDigit = 0;
        int lastDigit = 0;
        while ((!tempResult.equals("")) || letterCount > -1) {
            // Getting last digit
            if (!tempResult.equals("")) {
                char lastChar = tempResult.charAt(tempResult.length() - 1);
                currentDigit = Integer.parseInt(lastChar + "");
            } else {
                currentDigit = 0;
            }

            if (currentDigit == lastDigit || lastDigit == 0) {
                counter++;
            } else
            // if (currentDigit != lastDigit && lastDigit == 0)
            {
                result = Integer.toString(counter) + lastDigit + result;
                counter = 1;
            }
            lastDigit = currentDigit;
            letterCount--;
            if (!tempResult.equals(""))
                tempResult = tempResult.substring(0, tempResult.length() - 1);

        }
        return result;

    }

    // Approach 2:
    public static String countAndSay_approach2(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countIdxhelper_approach2(s);
        }
        return s;
    }

    public static String countIdxhelper_approach2(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {

        // String result = countAndSay(11); // Approach 1: Self written with recursion
        // System.out.println(result);

        String result = countAndSay_approach2(11); // Approach 2: Shorter
        System.out.println(result);

    }

}
