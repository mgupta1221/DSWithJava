package GettingStarted;

import java.util.Scanner;

/**
 * HelloWorld
 */
public class Inverse {

    public static void main(String[] args) {
        
        int n = 2134;
        int noOfDigits = 0;
        int rem = 0;
        int invrsedNo = 0;
        while (n != 0) {
            rem = n % 10;
            n = n / 10;
            noOfDigits++;
            invrsedNo = invrsedNo + (noOfDigits * (int) (Math.pow(10, rem-1)));
        }
        System.out.println(invrsedNo);

    }
}