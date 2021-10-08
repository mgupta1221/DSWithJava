package GettingStartedBasics.FunctionsAndArrays;
// Check readme in folder
// https://www.youtube.com/watch?v=LJ697zHLL0M&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=84


public class FromBaseAnyBaseToAnybase {
    public static void main(String[] args) {

        int n = 122;
        int sourcebase = 10;
        int targetbase = 2;
        int rem = 0;
        int resultingNumber = 0;
        int counter = 0;

        while (n != 0) {
            rem = n % targetbase;
            n = n / targetbase;

            resultingNumber += rem * Math.pow(sourcebase, counter++);

        }

        System.out.println(resultingNumber);

    }

}
