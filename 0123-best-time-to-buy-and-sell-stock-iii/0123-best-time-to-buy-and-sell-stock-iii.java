class Solution {

    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length+1][2+1][3];
        for(int t[][] : dp) {
            for(int t1[] : t)
                Arrays.fill(t1,-1);
        } 
        return solve(0, 1, 2,prices, dp);
    }
    private int solve(int n, int buy, int limit, int nums[], int dp[][][]) {
        if(n == nums.length)    return 0;
        if(limit == 0)  return 0;
        if(dp[n][buy][limit] != -1)    return dp[n][buy][limit];
        if(buy == 1) { // buy or skip
            return dp[n][buy][limit] = Math.max(-nums[n] + solve(n+1, 0, limit,nums, dp), solve(n+1, 1, limit,nums, dp)); 

        } else {    //sell or skip
            return dp[n][buy][limit] = Math.max(nums[n] + solve(n+1, 1, limit-1, nums, dp), solve(n+1, 0, limit,nums, dp)); 
        }
    }
}