class Solution {
    static int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(0,cost), solve(1,cost));
        
    }
    private static int solve(int i, int cost[]){
        if(i >= cost.length)    return 0;
        if(dp[i] != -1) return dp[i];
        
        return dp[i] = cost[i] + Math.min(solve(i+1, cost), solve(i+2, cost));
    }
}