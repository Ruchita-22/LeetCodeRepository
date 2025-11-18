class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];
        for(int t[] : dp) {
            Arrays.fill(t,-1);
        } 
        return solve(coins.length-1, amount, coins, dp);
    }
    private int solve(int n, int sum, int nums[], int dp[][]) {
        if(sum == 0)    return 1;
        if(n < 0)  return 0;
        if(dp[n][sum] != -1)    return dp[n][sum];

        if(sum >= nums[n])  return dp[n][sum] = solve(n,sum-nums[n], nums, dp) + solve(n-1, sum, nums, dp);
        else return dp[n][sum] = solve(n-1, sum, nums, dp);
    }
}