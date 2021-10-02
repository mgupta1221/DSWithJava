package FunctionsAndArrays;

import java.util.Scanner;

// Check readme in folder

// https://www.youtube.com/watch?v=_jcwos0_pSg&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=90

public class Rough {
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

        // Getting higher length comparing both arrays
        if (arrPointer1 > arrPointer2) {
            maxLength = arrPointer1 + 1;
        } else {
            maxLength = arrPointer2 + 1;
        }

        int[] resultArray = new int[maxLength];

        int carry = 0;
        int tempSum = 0;
        while (arrPointer1 > -1 || arrPointer2 > -1 || carry > 0) {
            int val1 = 0;
            int val2 = 0;
            if (arrPointer1 > -1) {
                val1 = arr1[arrPointer1];
            }
            if (arrPointer2 > -1) {
                val2 = arr2[arrPointer2];
            }

            tempSum = val1 + val2 + carry;

            if (tempSum > 10) {
                resultArray[maxLength - 1] = tempSum % 10;
                carry = tempSum / 10;
            } else {
                resultArray[maxLength - 1] = tempSum;
                carry = 0;
            }

            arrPointer1--;
            arrPointer2--;
            maxLength--;
        }

        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + "\t");
        }

    }

}
