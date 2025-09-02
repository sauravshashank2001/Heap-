/**Given an array and size k find the largest subarray of size k sum in the array */

public int maxKSizeSubArraySum(int[] arr, int k) {
    if (arr == null || arr.length == 0 || k <= 0) {
        throw new IllegalArgumentException("Invalid input");
    }

    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;

    for (int i = 0; i < arr.length; i++) {
        currentSum += arr[i];

        if (i >= k - 1) {
            maxSum = Math.max(maxSum, currentSum);
            currentSum -= arr[i - (k - 1)];
        }
    }

    return maxSum;
}

int[] arr = {2, 1, 5, 1, 3, 2};
int k = 3;
System.out.println(maxKSizeSubArraySum(arr, k));
