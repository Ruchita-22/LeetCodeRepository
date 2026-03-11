class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];
        Arrays.fill(dp,-1);

        return Math.min(solve(cost, cost.length-1, dp), solve(cost, cost.length-2, dp));
    }
    private int solve(int cost[], int n, int dp[]) {
        if(n == 0 || n == 1) return cost[n];

        if(dp[n] != -1) return dp[n];

        return dp[n] = cost[n] + Math.min(solve(cost, n-1, dp),solve(cost, n-2, dp));
    }
}