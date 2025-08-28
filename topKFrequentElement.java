/*
Top K Frequent Elements
Problem: Given an array, find the k most frequent elements.
Approach:
1. Use a HashMap to count frequencies.
2. Use a Min Heap to keep track of top k elements.
3. Return the elements in the heap.
*/

import java.util.*;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer,Integer> e : freq.entrySet()) {
            minHeap.add(e);
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) res[i] = minHeap.poll().getKey();
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr, 2))); // [1,2]
    }
}
