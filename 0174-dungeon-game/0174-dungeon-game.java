class Solution {
    public int calculateMinimumHP(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int dp[][] = new int[n+1][m+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        return solve(0, 0, grid, dp);
    }
    private int solve(int i, int j, int grid[][], int dp[][]) {
        if(!isValid(i,j, grid)) return Integer.MAX_VALUE;

        if(i == grid.length-1 && j == grid[0].length-1) return Math.max(1-grid[i][j], 1);
    
        if (dp[i][j] != -1) return dp[i][j];

        int ans = Math.min(solve(i+1, j, grid, dp),solve(i, j+1, grid, dp)) - grid[i][j];
        return dp[i][j] = ans <= 0 ? 1 : ans;  

    }
    private boolean isValid(int i, int j, int grid[][]) {
        return (i < grid.length && j < grid[0].length && i >= 0 && j >= 0);
    }
}