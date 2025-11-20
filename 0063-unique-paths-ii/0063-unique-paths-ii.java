class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePaths(obstacleGrid);
    }
    public int uniquePaths(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t, -1);
        return solve(m-1, n-1, obstacleGrid, dp);
    }
    private int solve(int i , int j, int[][] obstacleGrid, int dp[][]) {
        if(i == 0 && j == 0 && obstacleGrid[i][j] != 1)    return 1;
        if(i < 0 || j < 0 || obstacleGrid[i][j] == 1)    return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int left = solve(i, j-1, obstacleGrid, dp);
        int up = solve(i-1, j, obstacleGrid, dp);
        return dp[i][j] = left+up;
    }
}