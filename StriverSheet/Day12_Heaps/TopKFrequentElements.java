package StriverSheet.Day12_Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Problem: https://leetcode.com/problems/top-k-frequent-elements/description/

// Solution: 

// Approach:
// We will create a Hashmap<Integer, Integer>    for (Element,FrequencyCount) - basically each
// element with its frequency of occurnce
// Mext, We will create a MinHeap (via Priority Queue) ordered by "frequency", (not "value")and store 
// this hashMap in an class Object MapItem. We created class Object so that we can implement Comparable
// interface
// Now finally We will pop elements from Heap and store them in result and return

class MapItem implements Comparable<MapItem> {
    int val;
    int freq;

    public MapItem(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }

    public int compareTo(MapItem item) {
        return item.freq - this.freq; // this is for Descending, on reversing the varibales it will become ascending
    }
}

class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<MapItem> pq = new PriorityQueue<>();// creating Min Heap

        // Notice how we are iterating HashMap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            MapItem item = new MapItem(entry.getKey(), entry.getValue());
            pq.add(item);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().val;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int[] result = topKFrequent(nums, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

}
