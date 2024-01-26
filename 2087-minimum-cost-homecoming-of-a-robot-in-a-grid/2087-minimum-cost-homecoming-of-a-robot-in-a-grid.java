class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
       int result = 0 ;
        
        int startRow = Math.min(startPos[0], homePos[0]) ;
        int endRow = Math.max(startPos[0], homePos[0]) ;
        int startCol = Math.min(startPos[1], homePos[1]) ;
        int endCol = Math.max(startPos[1], homePos[1]) ;
        
        for (int i = startRow; i <= endRow; i++)
            result += rowCosts[i] ;
        
        for (int i = startCol; i <= endCol; i++)
            result += colCosts[i] ;
        
        result -= rowCosts[startPos[0]] ;
        result -= colCosts[startPos[1]] ;
        return result ;       
         
  
    }
    ///////////////////Below sol didn't work////////////////
    public int minCost1(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int m = rowCosts.length;
        int n = colCosts.length;
        
        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t, -1);
        
        int x1 = startPos[0];
        int y1 = startPos[1];
        int x2 = homePos[0];
        int y2 = homePos[1];
       
        return solve(x1, y1, x2, y2, rowCosts, colCosts, dp);       
         
  
    }
    private static int solve(int i, int j, int x2, int y2, int[] rowCosts, int[] colCosts, int dp[][]) {
        if(!isValid(i, j, rowCosts, colCosts))   return 0;
        if(i == x2 && j == y2)  return 0;
        
        if(dp[i][j] != -1)  return dp[i][j];
        
        int up = rowCosts[i] + solve(i-1, j, x2, y2, rowCosts, colCosts, dp);
        int down = rowCosts[i] + solve(i+1, j, x2, y2, rowCosts, colCosts, dp);
        int left = colCosts[j] + solve(i, j-1, x2, y2, rowCosts, colCosts, dp);
        int right = colCosts[j] + solve(i, j+1, x2, y2, rowCosts, colCosts, dp);
        
        return dp[i][j] = Math.min(Math.min(up, down), Math.min(left, right));
    }
    private static boolean isValid(int i, int j, int[] rowCosts, int[] colCosts) {
        int m = rowCosts.length;
        int n = colCosts.length;
        if(i < 0 || i >= m || j < 0 || j >= n)  return false;
        else return true;
    }
}