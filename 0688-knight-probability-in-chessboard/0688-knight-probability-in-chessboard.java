class Solution {
    int dir[][] = new int[][]{{-2, -1}, {-2, +1}, {-1, -2}, {-1, +2}, {+1, -2}, {+1, +2}, {+2,-1}, {+2, +1}};
    
    public double knightProbability(int n, int k, int row, int column) {
        double dp[][][] = new double[n+1][n+1][k+1];
     
        return solve(row, column, k, n, dp);
      
    }
    
    public double solve(int i, int j, int k, int n, double dp[][][]) {
        
        if(!isValid(i, j, n))   return 0.0;
        if(k == 0)  return 1.0;
        if(dp[i][j][k] != 0)   return dp[i][j][k];
        
        double ans = 0;
        for(int idx = 0; idx < 8; idx++){
            int r = i + dir[idx][0];
            int c = j + dir[idx][1];
            //if(isValid(r, c, n)) {
                ans += solve(r, c, k-1, n, dp);
            //}
        }
        return dp[i][j][k] += ans / 8.0; 
        
        
    }
    private static boolean isValid(int i, int j, int n) {
        if(i < 0 || i >= n || j < 0 || j >= n ) return false;
        else return true;
    }
    
    
}