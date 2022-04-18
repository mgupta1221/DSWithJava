package PepLevelUp.BitManipulation;

public class BitManiplationQuestions {

    // Power of 2 - LC 231
    private static boolean PowerOf2(int n) {

        return (n > 0) && ((n & n - 1) == 0);

        // Logic all numbers which are power of 2 like 2,4,8,16,32
        // They have a comon property that their AND operation with (n-1) will always be
        // 0
        // E.g. 8 is 1000. If we AND it with 7 i.e. 111, there AND will always be 0.
    }

    // Power of 4 - LC 342
    // TO DO
    private static boolean PowerOf4(int n) {

        return (n > 0) && ((n & n - 1) == 0);

    }

    // Single Number - LC 136
    private static int SingleNumber(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n; // using XOR operator
        }
        return result;
    }

    // Missing Number - LC 268
    private static int MissingNumber(int[] nums) {

        int xResult = nums[0];
        int yResult = 1;

        for (int j = 1; j < nums.length; j++) {
            xResult ^= nums[j];
        }

        for (int j = 2; j <= nums.length + 1; j++) {// notice +1
            yResult ^= j;
        }

        return xResult ^ yResult;
    }

    // Hamming Weight - LC 191
    // Trick to find the number of set bits(1) in a binary number
    // Trick is when we "AND" a number 'n' with 'n-1' number of set bits reduces by
    // Approach 1 - Hamming Weight
    // Aproach 2 - Using right shift operator

    private static int HammingWeight(int n) {
        int count = 0;
        while (n != 0) { // keep doing AND till all set bits turn 0, at the end you will get no of 1s.
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    // Approach 2: Using right shift operator - LC 191
    private static int HammingWeight_2(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {// & with '1' so that everytime you will understand if the last bit is 1 or not
                count++;
            }
            n = n >> 1;// right shift by 1, so everytime 1 bit from the right will be dropped
        }
        return count;
    }

    // LC- 338 -- Logic in video of 6th Apr
    // Idea is (n & (n-1)) will always have 1 less set bit than 'n' so we use this
    // logic
    public static int[] countingbits(int num) {
        System.out.println(4 & (-4)); // 110

        int[] result = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }

        return result;
    }

    // LC 260
    // Here we get the last set bit (mask) and 'AND' it with all numbers, to get the
    // 2 distinct vales
    // if the result is 0 than XOR it in one variable set , else in another.
    public static int[] singleNumber_3(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        int mask = result & (-result); // getting last set bit

        int a = 0;
        int b = 0;

        for (int n : nums) {
            if ((mask & n) == 0) {
                a ^= n; // grouping in one set
            } else
                b ^= n; // grouping in another set
        }
        return new int[] { a, b };

    }

    // TODO
    // Find Duplicate: LC 287
    // 1 number is duplicated
    public static int findDuplicate(int[] nums) {
       return 1;
        
    }

    public static void main(String[] str) {

        // boolean result = PowerOf2(32);

        // boolean result = PowerOf4(32);

        // int[] nums = { 2, 2, 1, 1, 3 };
        // int result = SingleNumber(nums);

        // int[] nums = { 2, 3, 5, 1, 6 };
        // int result = MissingNumber(nums);

        // int result = HammingWeight(31); // 5 is 101, 15 is 1111 in binary
        // int result = HammingWeight_2(7);
        // System.out.println(result);

        // int result[] = countingbits(5);
        // for (int n : result) {
        // System.out.println(n);
        // }

        int[] nums = { 1,3,4,2,2 };
        int result = findDuplicate(nums);
        System.out.println(result);

    }
}
