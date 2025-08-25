Heap
A heap is a special binary tree–based data structure with the following properties:

____________________________________________________________________________
Properties:

Shape Property:
A heap is a complete binary tree (every level is filled except possibly the last, and the last is filled from left to right).
This makes it efficient to store as an array (no pointers required).

Heap Property:
Max Heap: Every parent node is greater than or equal to its children. The maximum element is at the root.
Min Heap: Every parent node is less than or equal to its children. The minimum element is at the root.

____________________________________________________________________________
Representation in Array:
For a node at index i:
Left child = 2*i + 1
Right child = 2*i + 2
Parent = (i - 1) / 2
This avoids using explicit tree nodes.

____________________________________________________________________________
Operations (all in O(log n) except peek):
Insert → put element at the end, then “bubble up” to maintain heap property.
Remove (extract max/min) → remove root, replace with last element, then “bubble down” (heapify).
Peek (get max/min) → O(1).\
Heapify an array → build heap in O(n).

____________________________________________________________________________
Use cases:
Implementing Priority Queue (most common).
Heap Sort algorithm (O(n log n)).
Kth largest/smallest element in an array.
Efficient scheduling problems (e.g., CPU scheduling).