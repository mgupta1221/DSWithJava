package AdobeQues;

import java.util.ArrayList;

public class FacotorialsOfLargeNumber {
    // Problem: https://www.geeksforgeeks.org/factorial-large-number/

    // Approach:
    // 1. Create a Arraylist to store final number e.g. 5! will store as [1,2,0] 120
    // 2. Initialize the list with 1 . This list will store the product(digits of
    // products) of n! at each step of multiplication from 1-n
    // 3. Iterate through 2 to n (i)
    // 4. Now run another loop(j) to iterate all digit in current list(holding
    // product)
    // from right to left(becuase multiplicaiton happen from right to left) and in
    // this loop calculate product i.e. (currentList * i)

    // Notice : we have used 2 mthods of list: 'add' and 'set'
    // add(int index, E element): inserts the element at the given index. The
    // elements from the given index are shifted toward the right of the list.

    // set() - will set the element at specfied index WITHOUT Shifting elements

    public static ArrayList<Integer> factorial(int n) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); // this is important
        int carry = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) { // now calculate product by multiplying each element of
                                                         // exisitng lements in list with 'i'
                int digit = list.get(j);
                int product = (digit * i) + carry;
                list.set(j, product % 10); // 'list.set()'
                carry = product / 10;
            }
            while (carry > 0) {
                int digit = carry % 10;
                list.add(0, digit); // 'list.add()' - Notice carry
                carry = carry / 10;
            }
        }

        return list;

    }

    public static void main(String[] args) {
        ArrayList<Integer> result = factorial(5);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
}
