package GettingStartedBasics.FunctionsAndArrays;

// Check readme in folder

// https://www.youtube.com/watch?v=_jcwos0_pSg&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=90

public class AnyBaseMultiplication {
    public static void main(String[] args) {

        int base = 8;
        int n1 = 17;
        int n2 = 16;
        int tempn1;
        int digitN1 = 0;
        int digitN2 = 0;
        int digitTempSum = 0;
        int carry = 0;
        int tempFinalSum = 0;
        int finalSum = 0;
        int counter = 0;
        int finalCounter = 0;

        while (n2 != 0) {
            tempn1 = n1;
            // Gettings one digit everytime from right for additon from num2
            digitN2 = n2 % 10;
            n2 = n2 / 10;
            while (tempn1 != 0) {
                // Gettings one digit everytime from right for additon from num1
                digitN1 = tempn1 % 10;
                tempn1 = tempn1 / 10;

                // 18
                // 16
                // ======
                // 48
                // 108
                int tempMulti = digitN1 * digitN2 + carry; // 48
                digitTempSum = tempMulti % base; // 8

                if (tempMulti > base - 1) {
                    carry = tempMulti / base; // 4

                } else {
                    carry = 0;
                }
                tempFinalSum += digitTempSum * Math.pow(10, counter);
                counter++;
            }
            if (carry > 0) {
                tempFinalSum += carry * Math.pow(10, counter);
            }
            int newSum= (int) (tempFinalSum * Math.pow(10, finalCounter));
            finalSum = AnyBaseMultiplication.getSum(finalSum, newSum, base);
            finalCounter++;
            tempFinalSum = 0;
            counter = 0;
            carry = 0;

        }
        System.out.println(finalSum);

    }

    public static int getSum(int n1, int n2, int base) {

        int digitN1 = 0;
        int digitN2 = 0;
        int digitTempSum = 0;
        int carry = 0;
        int finalSum = 0;
        int counter = 0;

        while (n1 != 0 && n2 != 0) {
            // Gettings one digit everytime from right for additon from num1
            digitN1 = n1 % 10;
            n1 = n1 / 10;

            // Gettings one digit everytime from right for additon from num2
            digitN2 = n2 % 10;
            n2 = n2 / 10;

            // Adding digits and carry
            int tempSum = digitN1 + digitN2 + carry;

            // Getting digittTmpSum - the value to keep in result after addition, and rest
            // to move as carry
            // Note that for Base 10, max value can be 9, similarly for Binary max can be 1,
            // for Octal max can be 7
            digitTempSum = tempSum % base;

            // Carry needs to be created only If value is grater than 9(Base 10) or 1(Base
            // 2) or 7(Base 8)
            if (tempSum > base - 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            finalSum += digitTempSum * Math.pow(10, counter);
            counter++;

        }
        // If any number is finished with digits than add the other number remaining
        // digits
        // to the finalSum calculated so far

        // The below lines can also be moved by changing While condition from 'AND' to
        // 'OR' and carry > 0
        if (n1 > 0) {
            int t = n1 + carry;
            finalSum = finalSum + (int) Math.pow(10, counter) * t;

        } else if (n2 > 0) {
            int t = n2 + carry;
            finalSum = finalSum + (int) Math.pow(10, counter) * t;
        } else if (carry > 0) {
            int t = carry;
            finalSum = finalSum + (int) Math.pow(10, counter) * t;
        }
        return finalSum;
    }

}
