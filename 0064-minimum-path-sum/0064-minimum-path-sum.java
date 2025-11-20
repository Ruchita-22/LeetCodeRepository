class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t, -1);

        return solve(m-1, n-1, grid, dp);
    }
    private int solve(int i , int j, int[][] grid, int dp[][]) {
        if(i == 0 && j == 0)    return grid[i][j];
        if(i < 0 || j < 0)    return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int left = solve(i, j-1, grid, dp);
        int up = solve(i-1, j, grid, dp);
        return dp[i][j] = grid[i][j] + Math.min(left,up);
    }
}