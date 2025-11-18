class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+1][2+1];
        for(int t[] : dp) {
            Arrays.fill(t,-1);
        } 
        return solve(0, 1, prices, dp);
    }
    private int solve(int n, int buy, int nums[], int dp[][]) {
        if(n == nums.length)    return 0;
        if(dp[n][buy] != -1)    return dp[n][buy];
        if(buy == 1) { // buy or skip
            return dp[n][buy] = Math.max(-nums[n] + solve(n+1, 0, nums, dp), solve(n+1, 1, nums, dp)); 

        } else {    //sell or skip
            return dp[n][buy] = Math.max(nums[n] + solve(n+1, 1, nums, dp), solve(n+1, 0, nums, dp)); 
        }
    }
}