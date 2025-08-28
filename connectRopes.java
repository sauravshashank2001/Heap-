/**Connect Ropes with Minimum Cost

Problem: Given rope lengths, connect them into one rope with minimum cost.
Approach:

Use Min Heap.

Always pick 2 smallest, connect, push back.

Cost = sum of connections. */


import java.util.*;

public class ConnectRopes {
    public static int minCost(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int r : ropes) minHeap.add(r);

        int cost = 0;
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int sum = first + second;
            cost += sum;
            minHeap.add(sum);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        System.out.println(minCost(ropes)); // 29
    }
}