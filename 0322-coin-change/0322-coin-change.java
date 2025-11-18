class Solution {
    public int coinChange(int[] coins, int amount) {
         int dp[][] = new int[coins.length+1][amount+1];
        for(int t[] : dp) {
            Arrays.fill(t,Integer.MAX_VALUE);
        } 
        int ans =  solve(coins.length-1, amount, coins,dp);
        return ans == 10000000 ? -1 : ans;

        
    }
   
    private int solve(int n, int sum, int nums[], int dp[][]) {
        if(sum == 0)    return 0;
        if(n < 0)  return 10000000;
        if(dp[n][sum] != Integer.MAX_VALUE)    return dp[n][sum];

        if(nums[n] <= sum)  
            return dp[n][sum] = Math.min(1+solve(n,sum-nums[n], nums, dp) , solve(n-1, sum, nums, dp));
        else 
            return dp[n][sum] = solve(n-1, sum, nums, dp);
    }
}