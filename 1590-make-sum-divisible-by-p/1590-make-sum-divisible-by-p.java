class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        if(totalSum % p == 0) return 0;

        int targetSum = (int) (totalSum % p + p) % p;
        Map<Integer, Integer> map = new HashMap();
        // sumMod, index
        map.put(0, -1);
        long sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            int sumMod =(int)(sum % p);
            int prev = ((sumMod - targetSum) % p + p) % p;
            if( map.containsKey(prev) ) {
                ans = Math.min(ans, j-(map.get(prev)+1)+1);
            }
            map.put(sumMod, j);
        }
        return ans==nums.length ? -1 : ans;
    }
}