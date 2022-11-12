package StriverSheet.Day8_Greedy;

import java.util.Arrays;

// Problem: https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#

// Aproach:
// https://www.youtube.com/watch?v=Ls_AYoz1IX0

// Sort both arrival and departure times. Idea is if all trains come than
// what is the maximum number of platforms required so that overlapping trains at any point
// can stay on station at the same time. 
// Now after sorting, if in the loop keep comparing arrival and departure time . 
// If arrival time is appearing before departure at any point than increase count++
// becuase we need 1 new  platform for the new train, vice-versa if departure is before arrival
// at any point, than reduce the count that means we can free 1 platform as train has
// left from station. keep calcualting maxCOunt. At the end of while loop 
// maxCOunt will be the answer.

public class MinimumPlatforms {
    public static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 0;
        int maxCount = 0;
        int i = 0;
        int j = 0;
        while (i < n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
                maxCount = Math.max(maxCount, count);

            } else if (arr[i] > dep[j]) {
                count--;
                j++;

            }

        }
        return maxCount;

    }

    public static void main(String[] args) {
        // int[][] intervals = { { 0, 30 }, { 60, 240 }, { 90, 120 } };

        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

        // int[] arr = { 900, 1100, 1235 };
        // int[] dep = { 1000, 1200, 1240 };
        int result = findPlatform(arr, dep, arr.length);
        System.out.println(result);

    }

}

class Pair implements Comparable<Pair> {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Pair p) {
        return this.end - p.end;
    }

}
