import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Find remainder when total sum is divided by p
        int rem = (int)(sum % p);
        if (rem == 0) return 0; // If remainder is 0, no subarray needs to be removed

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Initialize to handle full prefix
        long currSum = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; ++i) {
            currSum += nums[i];
            int currentMod = (int)(currSum % p);
            int key = (currentMod - rem + p) % p;

            if (map.containsKey(key)) {
                ans = Math.min(ans, i - map.get(key));
            }

            map.put(currentMod, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}