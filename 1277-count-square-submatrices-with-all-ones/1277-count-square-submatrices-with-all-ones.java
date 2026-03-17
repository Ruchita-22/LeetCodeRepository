class Solution {
    public int countSquares(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp) Arrays.fill(t, -1);

        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                    ans += solve(i, j, grid, dp);
            }
        }
        
        return ans;
        
    }
    private int solve(int i, int j, int[][] grid, int dp[][]) {
    
        if(!isValid(i,j, grid) || grid[i][j] == 0)  return 0;

        if(dp[i][j] != -1)  return dp[i][j];

        int path1 = solve(i, j+1, grid, dp);
        int path2 = solve(i+1, j+1, grid, dp);
        int path3 = solve(i+1, j, grid, dp);
        return dp[i][j] = 1 + Math.min(path1, Math.min(path2, path3));
    }
    private boolean isValid(int i, int j, int grid[][]) {
        if(i < 0 || i >= grid.length  || j < 0 || j >= grid[0].length) return false;
        return true;

    }
}