class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[]= new int[target+1];
        Arrays.fill(dp,-1);
         
        return solve(target, nums, dp);
    }
   
    private int solve(int sum, int nums[], int dp[]) {
        if(sum == 0)    return dp[sum] = 1;
        if(sum < 0)  return 0;

        if(dp[sum] != -1)    return dp[sum];

        int ans = 0;
        for(int i = 0 ; i < nums.length; i++) {
            ans += solve(sum-nums[i], nums, dp);
        }
        return dp[sum] = ans;
    }
}