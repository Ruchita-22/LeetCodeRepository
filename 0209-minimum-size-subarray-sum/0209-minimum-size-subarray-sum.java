class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0, ans = Integer.MAX_VALUE;

        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if(sum >= target) {
                while(sum >= target) {
                    ans = Math.min(ans,j-i+1);
                    sum -= nums[i];
                    i++;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
        
    }
}