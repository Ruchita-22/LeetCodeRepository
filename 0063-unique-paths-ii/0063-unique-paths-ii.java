class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePaths(obstacleGrid.length, obstacleGrid[0].length, obstacleGrid);
    }
    public int uniquePaths(int m, int n, int[][] obstacleGrid) {
        int dp[][] = new int [m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t, -1);
        return solve(m-1, n-1, obstacleGrid, dp);
        
    }
    private int solve(int i, int j, int[][] obstacleGrid, int dp[][]) {
        System.out.println(i+" "+j);
        if(i < 0 || j < 0)  return 0;
        if(obstacleGrid[i][j] == 1) return 0;
        if(i == 0 && j == 0)    return 1;

        if(dp[i][j] != -1)  return dp[i][j];

        return dp[i][j] = solve(i-1, j, obstacleGrid, dp) + solve(i, j-1, obstacleGrid, dp);
    }
}