/**
 * Maximum Points You Can Obtain from Cards

There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 * 
 * cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 * 
 * 
 */


class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n - k;

        // Step 1: Find total sum
        int totalSum = 0;
        for (int x : cardPoints) {
            totalSum += x;
        }

        // Step 2: Find sum of the first window
        int currSum = 0;
        for (int i = 0; i < windowSize; i++) {
            currSum += cardPoints[i];
        }

        int minSum = currSum; // initialize with first window sum

        // Step 3: Slide the window
        for (int i = windowSize; i < n; i++) {
            currSum += cardPoints[i];                // add new element
            currSum -= cardPoints[i - windowSize];   // remove leftmost element
            minSum = Math.min(minSum, currSum);      // track minimum sum
        }

        // Step 4: Answer = total sum - min subarray sum
        return totalSum - minSum;
    }
}


