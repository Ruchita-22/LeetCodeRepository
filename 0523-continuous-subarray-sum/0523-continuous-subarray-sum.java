class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2 || k == 0) return false;
        var map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        int sum = 0, len = Integer.MAX_VALUE;
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            int currSumMod = (sum % k + k) % k;
            if(map.containsKey(currSumMod)) {
                len = Math.min(len, j - map.get(currSumMod)+1);
                if(j - map.get(currSumMod) >= 2) return true;
            }
            map.putIfAbsent(currSumMod, j);
        }
        return false;
    }
}