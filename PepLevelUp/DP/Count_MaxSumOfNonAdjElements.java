package PepLevelUp.DP;

public class Count_MaxSumOfNonAdjElements {

    // This is a Greedy problem

    // Problem:
    // https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
    // Similar problem - House robber:
    // https://leetcode.com/problems/house-robber/

    // Solution video:
    // https://www.youtube.com/watch?v=VT4bZV24QNo&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=23

    // Trick Diagram: "Count_MaxSumOfNonAdjElements.png"
    // Trick Diagram explanation below

    // Here we have to find minimum cost ensuring no 2 houses are adjacent:
    // https://www.geeksforgeeks.org/minimize-cost-of-painting-n-houses-such-that-adjacent-houses-have-different-colors/

    // Solution Approach:
    // here either the house will come or not come
    // We maintain 2 variables (incl, excl) for include and exclude and will keep
    // updating them with each iteration
    // If current item is included(that means last item cannot be included) than
    // last element's 'excluding' cost should be included
    // If current item is excluded than maximum of last element's 'including' and
    // 'excluding' cost should be included

    // Trick Diagram explanation:
    // initialze 'include' with arr[0] and 'exclude' with 0
    // If we include 10 than we can onyl take 'exclude of previous 5' and add to the
    // current value
    // I we exclude 10 than we can take both: Include and Exclude and take there
    // maximum
    private static int count_maxSumOfNonAdjElements(int[] nums) {
        int include = nums[0];
        int exclude = 0;
        int tempInclude = 0;

        for (int i = 1; i < nums.length; i++) {
            tempInclude = exclude + nums[i]; // temporarily storing as this is required in next line
            exclude = Math.max(include, exclude);
            include = tempInclude; // updating actual value with temp value
        }

        return Math.max(exclude, include);
    }

    public static void main(String[] args) {
        int[] houseCosts = { 5, 5, 10, 100, 10, 5 };
        int result = count_maxSumOfNonAdjElements(houseCosts);
        System.out.println(result);
    }

}
