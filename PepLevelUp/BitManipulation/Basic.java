package PepLevelUp.BitManipulation;

public class Basic {

    private static int leftShiftBy2(int x) {
        return x << 2;
    }

    private static int rightShift(int x) {
        return x >> 2;
    }

    // set a bit at aprticular index in a number
    private static int setBitTrue(int x, int idx) {
        int mask = 1 << idx; // Left shift 1 , idx times- this will add 0s to the right
        return x | mask; // than put the OR operator - Now the bit at index idx will be set to 1
    }

    private static int setBitFalse(int y, int idx) {
        int mask = ~(1 << idx); // taking 1s complement
        System.out.println(mask);

        return y & mask;
    }

    private static boolean isNumberEven(int x) {
        // Odd numbers have 1 as last digit(LSB) and Even nos have 0 as last digit(LSB)
        // AND with 1 (i.e. 000001), if we get 0 than number is 0 , if we get 1 than
        // number is 1
        return (x & 1) == 0 ? true : false;
    }

    private static boolean isNumberOdd(int x) {

        return (x & 1) == 0 ? true : false;
    }

    public static void main(String[] str) {
        // int result = leftShiftBy2(5); //5=101, result will be 10100 which is 20

        // left shift 2 i.e. (10 in binary) by 2 bits will be 8 becuase 0010 << 2 = 1000
        // (notice we consider trailing zeroes)

        // int result = rightShift(20);

        // int result = setBitTrue(20, 1); // 20 is 10100, we want to set second last 0
        // to
        // 1 so final value will be 10110

        // int result = setBitFalse(20, 1);

        boolean result = isNumberEven(37);
        System.out.println(result);
    }
}
