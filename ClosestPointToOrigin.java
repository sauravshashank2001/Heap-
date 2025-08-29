/**
 * K Closest Points to Origin
Problem Statement

We are given an array of points on the X-Y plane, points[i] = [xi, yi], and an integer k.
We need to return the k closest points to the origin (0,0).

The distance between a point (x, y) and the origin (0,0) is:

𝑑
𝑖
𝑠
𝑡
𝑎
𝑛
𝑐
𝑒
=
𝑥
2
+
𝑦
2
distance=x
2
+y
2

(since square root doesn’t affect comparison, we can avoid computing it).
 * 
 points = [[1,3],[-2,2]], k = 1
o/p-[[-2,2]]

 */

import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max Heap (store farthest at top)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(b), distance(a))
        );

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove farthest
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
