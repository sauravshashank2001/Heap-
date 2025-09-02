/**Longest Substring Without Repeating Characters */

/**
 * Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
 */


public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If character is already in current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                // Move left pointer to position after the duplicate
                left = map.get(currentChar) + 1;
            }
            
            // Update the character's position
            map.put(currentChar, right);
            
            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }