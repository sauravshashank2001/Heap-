/**
 * Sliding Window Maximum

Problem: Find max in each window of size k.
Approach:

Use Max Heap 
(max pq)(or better: Deque).

Each step: remove out-of-window elements, add new, record max.
 * 
 * 
 */

import java.util.*;

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        for (int i = 0; i < n; i++) {
            maxHeap.add(new int[]{nums[i], i});
            if (i >= k - 1) {
                while (maxHeap.peek()[1] <= i - k) maxHeap.poll();
                res[i - k + 1] = maxHeap.peek()[0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3))); 
        // [3,3,5,5,6,7]
    }
}
