/**
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.
 * 

 Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
 */


class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int subWithMaxK = subarrayWithAtMostK(nums, k);
        int reducedSubWithMaxK = subarrayWithAtMostK(nums, k - 1);
        return subWithMaxK - reducedSubWithMaxK;
    }
    
    public int subarrayWithAtMostK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            
            ans += right - left + 1; // Size of subarray
            right++;
        }
        
        return ans;
    }
}