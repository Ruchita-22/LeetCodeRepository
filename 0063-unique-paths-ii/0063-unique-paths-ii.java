class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp) Arrays.fill(t, -1);

        return solve(m-1, n-1, obstacleGrid, dp);
        
    }

    private int solve(int i, int j, int[][] grid, int dp[][]) {
        if(i == 0 && j == 0 && grid[i][j] != 1)    return 1;
        if(i < 0 || j < 0 || grid[i][j] == 1)  return 0;

        if(dp[i][j] != -1)  return dp[i][j];

        int up = solve(i-1, j, grid, dp);
        int left = solve(i, j-1, grid, dp);
        return dp[i][j] = up + left;
    }
}