class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
	    int m = s2.length();
	     int dp[][] = new int[n+1][m+1];
        for(int t[] : dp)   Arrays.fill(t, -1);
	    return solve(n, m, s1, s2, dp);
    }
    
  
    private static int solve(int n, int m, String x, String y, int dp[][]){
        if(n == 0 && m == 0)    return 0;
        if(dp[n][m] != -1)  return dp[n][m];
        
        if(n == 0){
            return dp[n][m] = y.charAt(m-1) + solve(n, m-1, x, y, dp);
        }
         if(m == 0){
            return dp[n][m] = x.charAt(n-1) + solve(n-1, m, x, y, dp);
        }
       
        if(x.charAt(n-1) == y.charAt(m-1))  
            return dp[n][m] = solve(n-1, m-1, x, y, dp);
        else 
            return dp[n][m] = Math.min ( x.charAt(n-1) + solve(n-1, m, x, y, dp) , y.charAt(m-1) + solve(n, m-1, x, y, dp));
       
        
    }
}