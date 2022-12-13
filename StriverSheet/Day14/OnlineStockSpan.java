package StriverSheet.Day14;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StockSpanner {

    // Problem: LC 901 https://leetcode.com/problems/online-stock-span/description/

    // 2 approaches:
    // Approach 1: Solved with the technique of "Next Greater Element"
    // Approach 2: Without using stack (using List)

    // In approach 2: In worst case, for 1st input it will check 1 time in the list,
    // for 2nd input it will check 2 times, so on..
    // For nth input(last input) it will iterate n times.
    // Time Complexity = 1+2+3+....n = n*(n+1)/2 = O(n2)

    Stack<Integer> st;
    int itr = 0;
    int[] stackValues = new int[10000];

    public StockSpanner() {
        st = new Stack<>();
        itr = 0;
    }

    public int next_approachWithStack(int price) {
        stackValues[itr] = price;
        int result = 0;

        while (!st.empty() && price >= stackValues[st.peek()]) {
            st.pop();
        }

        if (st.isEmpty()) {
            result = itr + 1;
        } else {
            result = itr - st.peek();
        }
        st.push(itr);
        itr++;

        return result;
    }

    //
    List<Integer> list = new ArrayList<>();

    public int next_approachWithoutStack(int price) {
        list.add(price);
        int c = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (price < list.get(i)) {
                break;
            }
            c++;
        }
        return c;
    }
}

public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next_approachWithStack(100)); // return 1
        System.out.println(stockSpanner.next_approachWithStack(80)); // return 1
        System.out.println(stockSpanner.next_approachWithStack(60)); // return 1
        System.out.println(stockSpanner.next_approachWithStack(70)); // return 2
        System.out.println(stockSpanner.next_approachWithStack(60)); // return 1
        System.out.println(stockSpanner.next_approachWithStack(75)); // return 4, because the last 4 prices (including
                                                                     // today's price of
        // 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next_approachWithStack(85)); // return 6

    }
}
