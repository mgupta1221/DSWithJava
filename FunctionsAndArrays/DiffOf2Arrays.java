package FunctionsAndArrays;

import java.util.Scanner;

// Check readme in folder

// https://www.youtube.com/watch?v=jKyuWD8XKjw&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=102

// Assumption - Number 2 is always greater than number 1

public class DiffOf2Arrays {
    public static void main(String[] args) {

        
        Scanner scn = new Scanner(System.in);

        int numberOfElements = scn.nextInt();
        int[] arr1 = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            arr1[i] = scn.nextInt();
        }
        numberOfElements = scn.nextInt();
        int[] arr2 = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            arr2[i] = scn.nextInt();
        }
        int arrPointer1 = arr1.length - 1;
        int arrPointer2 = arr2.length - 1;
        int maxLength = 0;

        // Getting higher length comparing both arrays to define result array
        if (arrPointer1 > arrPointer2) {
            maxLength = arrPointer1 + 1;
        } else {
            maxLength = arrPointer2 + 1;
        }

        int[] resultArray = new int[maxLength];

        int carry = 0;

        // run till arrays exist or carry value exists
        while (arrPointer1 > -1 || arrPointer2 > -1 || carry > 0) {
            int val1 = 0;
            int val2 = 0;
            // this condition is to consider value as 0 if array has ended else take the
            // actual value
            if (arrPointer1 > -1) {
                val1 = arr1[arrPointer1];
            }
            if (arrPointer2 > -1) {
                val2 = arr2[arrPointer2];
            }

            // Below 'if' means when numerator > denomintor so direct subrtraction and Zero Carry
            if (val2 > val1) {
                resultArray[maxLength - 1] = val2 - val1 + carry;
                carry = 0;
            } else {
                // if carry is there for current calucaltion than 9 will be added else 10
                // This is how subtraction works
                if (carry != 0) {
                    resultArray[maxLength - 1] = val2 - val1 + 9;

                } else {
                    resultArray[maxLength - 1] = val2 - val1 + 10;
                }
                // this is 'else loop' means when numerator < denomintor so carry will be
                // borrowed
                // hence carry is -1
                carry = -1;
            }

            arrPointer1--;
            arrPointer2--;
            maxLength--;
        }

        // removing all trailing zeroes from result ---e.g. 008905 should be output as
        // 8905
        int pointer = 0;
        while (pointer <= resultArray.length) {
            // checking till we find first non-zero value from left
            if (resultArray[pointer] == 0) {
                pointer++;
            } else {
                // break on finding first non-zero value
                break;
            }
        }

        for (int i = pointer; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + "\t");
        }

    }

}
