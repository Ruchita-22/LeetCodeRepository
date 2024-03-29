//https://www.youtube.com/watch?v=-RwOEYcsQU0&list=PLpIkg8OmuX-L_QqcKB5abYynQbonaNcq3&index=65
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double dp[][] = new double[query_row+1][query_glass+1];
        
        for(double t[] : dp)   Arrays.fill(t, -1.0);
        double ans =  solve(query_row, query_glass, poured, dp);
        return Math.min(1.0, ans);
    }
    public double solve(int i, int j, int poured, double dp[][]) {
        if(i < 0 || j < 0 || i < j) return 0.0;
        
        if(i == 0  && j == 0)   return poured;
        if(dp[i][j] != -1.0)  return dp[i][j];
        
        double left = ( solve(i-1, j - 1, poured, dp) - 1 ) / 2.0;
        double right = ( solve(i-1, j, poured, dp) - 1 ) / 2.0;
        
        if(left < 0) left = 0.0;
        if(right < 0) right = 0.0;
         
        return  dp[i][j] = left + right;
        
    }
}