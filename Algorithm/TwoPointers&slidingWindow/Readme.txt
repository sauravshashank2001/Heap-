Two Pointer Pattern
_________________________
What it is: Use two indices (left and right) to iterate over an array or string.
When to use:
Sorted arrays (move pointers inward/outward based on conditions).
Checking subsequences.
Eliminating extra passes over data.
Example: Find if a sorted array has a pair that sums to a target.


Sliding Window Pattern
________________________________
What it is: A "window" moves across data to maintain a subset (fixed-size or variable-size).
When to use:
Subarray/substring problems.
"Longest" or "smallest" constraints.
Continuous segments.
Types:
    Fixed window: window size is constant (like sum of subarray of size k).
    Dynamic window: expand/shrink until condition is met (like "longest substring with at most K distinct characters")