class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        
        return Math.min(solve(n-1, cost, dp), solve(n-2, cost, dp));
    }
     
    private static int solve(int n, int arr[], int dp[]) {
        if(n == 0)  return arr[0];
        if(n == 1)  return arr[1];
    
        if(dp[n] != -1)  return dp[n];
        
        return dp[n] = arr[n] + Math.min(solve(n - 1, arr, dp) , solve(n - 2, arr, dp)); 
    }
}
                                         
                                         
                                         
                                         
                                         