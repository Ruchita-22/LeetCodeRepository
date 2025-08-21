class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int [m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t, -1);
        return solve(m-1, n-1, dp);
        
    }
    private int solve(int i, int j, int dp[][]) {
        if(i == 0 && j == 0)    return 1;
        if(i < 0 || j < 0)  return 0;
        if(dp[i][j] != -1)  return dp[i][j];
        return dp[i][j] = solve(i-1,j, dp)+solve(i, j-1, dp);
    }
}