class Solution {
    public int maxUncrossedLines(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        
        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t, -1);
        
        
        return solve(m-1, n-1, arr1, arr2, dp);
    }
    private static int solve(int m, int n, int[] arr1, int[] arr2, int dp[][]) {
        if(m < 0 || n < 0)  return 0;
        if(dp[m][n] != -1)  return dp[m][n];
        
        if(arr1[m] == arr2[n]) {
            return dp[m][n] = 1 + solve(m-1, n-1, arr1, arr2, dp);
        } else {
            return dp[m][n] = Math.max(solve(m-1, n, arr1, arr2, dp), solve(m, n-1, arr1, arr2, dp));
        }
    }
}