package GettingStarted;

/**
 * https://www.youtube.com/watch?v=D_yKIOnhMRc&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=22
 */
public class ReverseANumber {

    public static void main(String[] args) {

        int n = 123456789;
        int tempNumber = n;
        int currentDigit;
        int reversedNumber = 0;

        while (tempNumber != 0) {
            currentDigit = tempNumber % 10;
            tempNumber = tempNumber / 10;
          
            reversedNumber = reversedNumber *10+ currentDigit;          
        }

       
        System.out.println(reversedNumber);

    }
}
