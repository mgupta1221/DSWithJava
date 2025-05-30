package StriverSheet.Day8_Greedy;

import java.util.Arrays;

// problem: https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

// What is the maximum number of meetings that can be accommodated in the meeting
// room when only one meeting can be held in the meeting room at a particular time?

// Notice in this solution we sort by Meeting End time(not start time).
// Reason: 
// Say if you have two meetings, one which gets over early and another which 
// gets over late. Which one should we choose?  
// If our meeting lasts longer the room stays occupied and we lose our time. On 
// the other hand, if we choose a meeting that finishes early we can accommodate more
// meetings. Hence we should choose meetings that end early and utilize 
// the remaining time for more meetings.

// Time Complexity: O(n) to iterate through every position and insert them in a data structure.
//  O(n log n)  to sort the data structure in ascending order of end time. O(n)  to iterate through
// the positions and check which meeting can be performed.
// Overall : O(n) +O(n log n) + O(n) ~O(n log n)

public class NMeetingRooms {

    public static int canAttendMeetings(int start[], int end[], int n) {
        if (start.length == 0)
            return 0;
        Pair[] pairs = new Pair[start.length];
        for (int i = 0; i < start.length; i++) {
            pairs[i] = new Pair(start[i], end[i]);
        }

        // Sorting by end time for this problem
        Arrays.sort(pairs);
        Pair prev = pairs[0];

        int count = 1; // Notice we are initializing the count with 1 and NOT 0

        for (int i = 1; i < pairs.length; i++) {
            if (prev.end < pairs[i].start) {
                count++;
                prev = pairs[i];
            }
        }

        return count;

    }

    public static void main(String[] args) {
        // int[][] intervals = { { 0, 30 }, { 60, 240 }, { 90, 120 } };

        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };
        int result = canAttendMeetings(start, end, start.length);
        System.out.println(result);

    }

}
