package GettingStartedBasics.GettingStarted;



/**
 * https://www.youtube.com/watch?v=O7PlWc9lOzg&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=24
 * 
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