1. Notice how to iterate HashMap in TopKFrequentElements.java

for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    MapItem item = new MapItem(entry.getKey(), entry.getValue());
    pq.add(item);
}


2. For Descending  order in CompareTo, use:
public int compareTo(MapItem item) {
    return item.freq - this.freq;
}


For "Ascending" order in CompareTo, use:
public int compareTo(MapItem item) {
    return this.freq - item.freq;
}

For above see "TopKFrequentElements.java"
