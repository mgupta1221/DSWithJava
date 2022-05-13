package PepLevelUp.DP;

import java.util.Arrays;
import java.util.Scanner;

// Problem:  https://www.geeksforgeeks.org/dynamic-programming-building-bridges/?ref=gcse
// Solution : https://www.youtube.com/watch?v=o1h3aoeSTOU

// Also, check this problema and its solution:
// https://leetcode.com/problems/non-overlapping-intervals/
// Solution:
// https://leetcode.com/problems/non-overlapping-intervals/discuss/2034023/Java%3A-O(nLogn)-Solution

// Trick Diagram: Count_NonOverlappingBridges.png

// Here we have to find maximum bridges between North and South which are not crossing
// (overlapping) each other
// We used the approach that: Agar kisi bhi 2 bridge ka north North se chota ho, South South se chota ho
// tab bridge overlapping honge 
//  e.g. Bridge 1:  [1,3]------Bridge 2:[6,8]
// isme Bridge 1 ka north 1 hai aur Bridge 2 ka north 6 hai...
// Simiarly  Bridge 1 ka south 3 hai aur Bridge 2 ka sourth 8 hai...
// upar wali condition fulfil ho rhi hai..isliye ye non overlapping honge

// Technical solution:
// Pehle  hum North ke basis pe Sort kar lnege fir South pe LIS laga denge..jo maxLength aayegi LIS se wo
// maxium number of bridges hogi

// Creating custom class for Bridge to store North, South values in pair 
// Implementing Comparable to sort array of class (CityBridge[]) based on North property
class CityBridge implements Comparable<CityBridge> {
    int north, south;

    CityBridge(int nb, int sb) {
        this.north = nb;
        this.south = sb;
    }

    // Notice how we override Comparable's compareTo method becuase we have to sort
    // array of Class CityBridge[].
    // Sorting cna than be done as Arrays.sort(CityBridgesArray)
    public int compareTo(CityBridge o) {
        // if 'north' value is same, than sort on 'south' value
        if (this.north == o.north) {
            return this.south - o.south;
        }
        return this.north - o.north;
    }
}

public class Count_NonOverlappingBridges {

    private static int FindNonOverlappingBridges(CityBridge[] bridgesList) {
        // Sorting by North values
        Arrays.sort(bridgesList);

        // and Implementing LIS on South Values
        int[] dp = new int[bridgesList.length];
        int maxLength = 1;
        for (int i = 0; i < bridgesList.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (bridgesList[j].south < bridgesList[i].south && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        // returning maxLength from LIS
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Getting inputs from user and creating custom objects for Bridge class with
        // <Borth, South pair>
        // We created class so that we can sort array of Bridge class.

        String northBridges = scn.nextLine(); // Enter these in 1 line as input :- 1 6 5 7
        String southBridges = scn.nextLine(); // 2 5 6 1

        String[] nbValues = northBridges.split(" ");
        String[] sbValues = southBridges.split(" ");

        CityBridge[] bridgesList = new CityBridge[nbValues.length];// creating array of bridge class
        for (int j = 0; j < nbValues.length; j++) {

            bridgesList[j] = new CityBridge(
                    Integer.parseInt(nbValues[j]), // converting string to int
                    Integer.parseInt(sbValues[j]));

        }

        // for (int j = 0; j < bridgesList.length; j++) {
        // System.out.println(bridgesList[j].north + "- " + bridgesList[j].south);
        // }

        int result = FindNonOverlappingBridges(bridgesList);
        System.out.println(result);

    }
}
