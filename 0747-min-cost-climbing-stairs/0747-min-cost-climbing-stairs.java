class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost.length-1, cost, dp),solve(cost.length-2, cost, dp));
    }
    private static int solve(int n, int[] cost, int dp[]) {
        if(n == 0 || n == 1) return dp[n] = cost[n];
        if(dp[n] != -1) return dp[n];
        return dp[n] = cost[n] + Math.min(solve(n-1, cost, dp), solve(n-2,cost, dp));

    }
}