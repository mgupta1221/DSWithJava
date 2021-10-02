package patterns;

//import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=8Cyb3X5j1Rw&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=60
 * This problem uses the below mathemtical formulae : nCk= n! / k! * (n-k)!
 * Also, nC0 = 1 ,and, nCn = 1 (will always be)
 * 
 * The last row is 1 5 10 10 5 1 which can be calculated as 5C0 5C1 5C2 5C3 5C4 5C5
 * 
 * 
 * so we have to start the outer loop(i) from 0 till 4(to print 5 rows) and inner loop(j) will be
 * 0 to n (NOT n-1) becuase in each row we are printing (n+1) columns
 * 
 * Now the important formula is nC(k+1) = nCk * (n-k/k+1) which means
 * 
 * iC(j+1) = iCj * (i-j)/(j+1)
 * 
 * which also means you can caculate next value from previous value, sam elogic is used in the solution below
 */
public class Pattern13 {

    public static void main(String[] args) {

        int n = 5;

        // Always remember outer loop will represent the number of rows to be printed
        for (int i = 0; i <= n; i++) {
            int iCj = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(iCj + " ");
                int iCj1 = iCj * (i - j) / (j + 1);
                iCj = iCj1;   // reasining to print in next iteration
            }
            System.out.println("");
        }

    }
}
