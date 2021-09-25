package FunctionsAndArrays;


// https://www.youtube.com/watch?v=F0aTGc2vS5s&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=82
public class FromBaseNTo10 {
    public static void main(String[] args) {

        int n = 101;
        int sourcebase = 2;
        int targetbase = 10;
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
