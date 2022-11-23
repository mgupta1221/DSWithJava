package StriverSheet.Day8_Greedy;

import java.util.Arrays;

// Problem Geeks for Geeks: https://takeuforward.org/data-structure/job-sequencing-problem/

// Solution: https://www.youtube.com/watch?v=--bP0uCf4cU

public class JobSequencing {

    public static int[] JobScheduling(Job arr[], int n) {
        // Sort Jobs by Profit
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        // Find max deadline
        int max_deadline = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > max_deadline) {
                max_deadline = arr[i].deadline;
            }
        }

        // creaitng an array with length = max deadline
        boolean[] result = new boolean[max_deadline + 1];

        // Fill all cells with false initially
        Arrays.fill(result, false);

        int count = 0;
        int maxProfit = 0;

        // loop through jobs and start filling from backwards. We are trying to complete
        // jobs at the last interval as much as possible hence looping reverse.
        // Idea ye hai ki ek job apni given deadine se pehle kabhi bhi khatam kiya ja
        // sakta hai..hum koshish ye kar rhe hain ki har job apni deadline par hi
        // complete ho taaki baaki jobs usse pehle khatam kiye jaa sakein aur profit max
        // ho sake
        // agar result[j] fill nahi hai iska matlab us deadline par koi job finish
        // nahi kiya gaya hai
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].deadline; j >= 1; j--) { // ye loop isliye hai kyunki ye job apni deadline se pehle
                                                         // kabhi bhi kiya ja sakta hai E.g. say deadline is 3 for a Job
                                                         // than it can be completed in 3,2 or 1. but hum descending
                                                         // loop isliye chala rhe hain kyunki jitna last mai job mai job
                                                         // ko khaam karenge..utna profit max hoga..
                                                         // Notice loop will go till 1, not 0
                if (result[j] == false) {
                    result[j] = true;
                    count++;
                    maxProfit = maxProfit + arr[i].profit;

                    break;
                }

            }
        }

        int[] finalResult = new int[2];
        finalResult[0] = count;
        finalResult[1] = maxProfit;

        return finalResult;

    }

    public static void main(String[] args) {
        // Job job1 = new Job(1, 4, 20);
        // Job job2 = new Job(2, 1, 10);
        // Job job3 = new Job(3, 1, 40);
        // Job job4 = new Job(4, 1, 30);

        Job job1 = new Job(1, 2, 100);
        Job job2 = new Job(2, 1, 19);
        Job job3 = new Job(3, 2, 27);
        Job job4 = new Job(4, 1, 25);
        Job job5 = new Job(5, 1, 15);
        Job arr[] = new Job[5];
        arr[0] = job1;
        arr[1] = job2;
        arr[2] = job3;
        arr[3] = job4;
        arr[4] = job5;

        int[] result = JobScheduling(arr, 4);
        System.out.println(result[0]);
        System.out.println(result[1]);

    }

}

class Job {
    int id;
    int deadline;
    int profit;

    Job(int jobId, int deadline, int profit) {
        this.id = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }
}