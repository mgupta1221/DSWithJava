package Strings;

import java.util.ArrayList;

public class RemovePrimes {

    // Quesiton and Solution: https://www.youtube.com/watch?v=jj90JZ_wLoo

    public static void main(String[] args) {

        int[] tempArray = { 11, 13, 15, 17, 18, 21, 23 };

        ArrayList<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < tempArray.length; i++) {
            arrList.add(tempArray[i]); // just tranferrign elements from Array to ArrayList
        }


        // Checking if number is prime and If Yes than removing

        for (int i = arrList.size() - 1; i >= 0; i--) { // notice we are iterating the loop from length to 0, reasons in Readme file and in Video

            var item = arrList.get(i); // Notice arrList[i] will not work, use 'get' method
            if (isPrime(item)) {
                arrList.remove(i);

            }
        }

        // Priting the new array as result
        for (int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.get(i) + "\t");
        }

    }


    //Checking if the number is Prime
    public static boolean isPrime(int n) {

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

}
