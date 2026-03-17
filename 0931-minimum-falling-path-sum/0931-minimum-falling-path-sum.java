class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp) Arrays.fill(t, Integer.MAX_VALUE);

        int ans = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++) {
            int tempAns = solve(0, j, grid, dp);
            ans = Math.min(ans, tempAns);
        }
        return ans;
    }
    
    private int solve(int i, int j, int[][] grid, int dp[][]) {
        if(i == grid.length-1 && j >= 0 && j < grid[0].length)    return grid[i][j];
        if(!isValid(i,j, grid))  return Integer.MAX_VALUE;

        if(dp[i][j] != Integer.MAX_VALUE)  return dp[i][j];
        
        int path1 = j > 0 ? solve(i+1, j-1, grid, dp) : Integer.MAX_VALUE;
        int path2 = solve(i+1, j, grid, dp);
        int path3 = j < grid[0].length-1 ? solve(i+1, j+1, grid, dp) : Integer.MAX_VALUE;
        return dp[i][j] = grid[i][j] + Math.min(path1, Math.min(path2, path3));
    }
    private boolean isValid(int i, int j, int grid[][]) {
        if(i < 0 || i >= grid.length  || j < 0 || j >= grid[0].length) return false;
        return true;

    }

}