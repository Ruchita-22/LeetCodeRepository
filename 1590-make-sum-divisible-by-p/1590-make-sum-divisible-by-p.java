class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % p == 0) return 0;

        int k = (int)(sum % p + p) % p;

        // we need to remove the smallest subarray whose sum = k

        var map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        sum = 0;
        int len = nums.length;
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            int currMod = (int)((sum % p + p) % p);
            int target = (currMod - k + p) % p;
            if(map.containsKey(target)) {
                len = Math.min(len, j - map.get(target) );
            }
            map.put(currMod, j);
        }
        return len == nums.length ? -1 : len;
    }
}