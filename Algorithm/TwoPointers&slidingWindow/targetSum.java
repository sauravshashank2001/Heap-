
/**Example: Find if a sorted array has a pair that sums to a target. */

public static void func() {

    int[] arr = {1, 2, 4, 6, 8, 9};
    int target = 10;
    int left = 0, right = arr.length - 1;
    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == target) {
            System.out.println("Pair found: " + arr[left] + ", " + arr[right]);
            break;
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }

}
