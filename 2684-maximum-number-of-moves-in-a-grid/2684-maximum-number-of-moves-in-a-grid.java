class Solution {
    int dir[] = new int[]{-1, 0, +1};
    public int maxMoves(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int dp[][] = new int[n+1][m+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(i, 0, grid, dp));
        }
        return ans;
    }
    private int solve(int i, int j, int grid[][], int dp[][]) {
        if(j == grid[0].length-1) return 0;
    
        if (dp[i][j] != -1) return dp[i][j];

        int res = 0;
        for(int d : dir) {
            int newI = i+d;
            int newJ = j+1;
            if(isValid(newI, newJ, grid) && grid[newI][newJ] > grid[i][j])
                res = Math.max(res,  1 + solve(newI, newJ, grid, dp));
        }

        // int x = 1 + solve(i-1, j+1, grid[i][j], grid, dp);
        // int y = 1 + solve(i, j+1, grid[i][j], grid, dp);
        // int z = 1 + solve(i+1, j+1, grid[i][j], grid, dp);
        return dp[i][j] = res;//Math.max(x , Math.max(y , z));
        

    }
    private boolean isValid(int i, int j, int grid[][]) {
        return (i < grid.length && j < grid[0].length && i >= 0 && j >= 0);
    }
}