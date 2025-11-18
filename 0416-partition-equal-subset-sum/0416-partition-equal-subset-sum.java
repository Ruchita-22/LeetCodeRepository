class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }    
        if(sum % 2 != 0) return false;

        int dp[][] = new int[nums.length+1][sum+1];
        for(int t[] : dp) {
            Arrays.fill(t,-1);
        } 
        return solve(nums.length-1, sum/2, nums,dp) == 1;
        
    }
    private int solve(int n, int sum, int nums[], int dp[][]) {
        if(sum == 0)    return 1;
        if(n < 0)  return 0;
        if(dp[n][sum] != -1)    return dp[n][sum];

        if(sum >= nums[n])  return dp[n][sum] = solve(n-1,sum-nums[n], nums, dp) | solve(n-1, sum, nums, dp);
        else return dp[n][sum] = solve(n-1, sum, nums, dp);

        

    }
}