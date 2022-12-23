package StriverSheet.Day16_StringII;

// Problem:  LC: 165 : https://leetcode.com/problems/compare-version-numbers/

public class CompareVersionNumbers {

    // Approach 1
    public static int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        int len1 = version1.length();
        int len2 = version2.length();
        while (i < len1 && j < len2) {
            String tempNumStr1 = "";
            while (i < len1 && version1.charAt(i) != '.') {
                tempNumStr1 += version1.charAt(i) + "";
                i++;
            }
            String tempNumStr2 = "";
            while (j < len2 && version2.charAt(j) != '.') {
                tempNumStr2 += version2.charAt(j) + "";
                j++;
            }
            int num1 = Integer.parseInt(tempNumStr1);
            int num2 = Integer.parseInt(tempNumStr2);
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
            i++;
            j++;
        }

        while (i < len1) {
            String tempNumStr1 = "";
            while (i < len1 && version1.charAt(i) != '.') {
                tempNumStr1 += version1.charAt(i) + "";
                i++;
            }

            int num1 = Integer.parseInt(tempNumStr1);
            if (num1 < 0) {
                return -1;
            } else if (num1 > 0) {
                return 1;
            }
            i++;
        }
        while (j < len2) {

            String tempNumStr2 = "";
            while (j < len2 && version2.charAt(j) != '.') {
                tempNumStr2 += version2.charAt(j) + "";
                j++;
            }
            int num2 = Integer.parseInt(tempNumStr2);
            if (0 < num2) {
                return -1;
            } else if (0 > num2) {
                return 1;
            }
            j++;
        }

        return 0;

    }


    // Appraoch 2
    public static int compareVersion2(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        int i1 = 0, i2 = 0;
        int s1 = 0, s2 = 0;
        while (i1 < v1.length || i2 < v2.length) {

            while (i1 < v1.length && v1[i1] != '.')
                i1++;

            while (i2 < v2.length && v2[i2] != '.')
                i2++;

            int a = s1 < v1.length ? Integer.valueOf(version1.substring(s1, i1)) : 0;
            int b = s2 < v2.length ? Integer.valueOf(version2.substring(s2, i2)) : 0;

            if (a > b)
                return 1;
            if (a < b)
                return -1;

            s1 = ++i1;
            s2 = ++i2;
        }
        return 0;
    }

    public static void main(String[] args) {
        // String version1 = "1.01";
        // String version2 = "1.001"; // ans 0

        // String version1 = "1.0";
        // String version2 = "1.0.0"; // ans 0

        // String version1 = "0.1";
        // String version2 = "1.1"; // ans -1

        String version1 = "1.0.1";
        String version2 = "1"; // ans 1
        int result = compareVersion2(version1, version2);
        System.out.println(result);

    }

}
