1. MaxHeap can be used directly using 'PriorityQueue' as used in "MaxSumCombination" question.


2. Notice how to iterate HashMap in TopKFrequentElements.java

for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    MapItem item = new MapItem(entry.getKey(), entry.getValue());
    pq.add(item);
}

Important: HashMap cannot be iterated over index like Strings and Arrays. Get() and put() functins of hashMap work only on key, not on Index
    Below is the way to iterate through HashMap via keySet.

    Used in 'Valid Anagaram' problem - Approach 3
   
    Set<Character> keys = map.keySet();
    for (Character key : keys) {
        if (map.get(key) != 0) {
            return false;
        }
    }


3. For Descending  order in CompareTo, use:
public int compareTo(MapItem item) {
    return item.freq - this.freq;
}


For "Ascending" order in CompareTo, use:
public int compareTo(MapItem item) {
    return this.freq - item.freq;
}

For above see "TopKFrequentElements.java"
