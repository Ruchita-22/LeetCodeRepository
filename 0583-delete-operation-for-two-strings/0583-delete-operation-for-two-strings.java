class Solution {
    public int minDistance(String word1, String word2) {
	    int n = word1.length();
	    int m = word2.length();
	    // int dp[][] = new int[n+1][m+1];
	    // for(int t[] : dp)   Arrays.fill(t,-1);
	    int l =  solve(n, m, word1, word2);
        return m + n - 2*l;
        
    }
    private static int solve(int n, int m, String x, String y){
        int dp[][] = new int[n+1][m+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0)  dp[i][j] = 0;
            }
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(x.charAt(i-1) == y.charAt(j-1))
                     dp[i][j]  = 1 + dp[i-1][j-1] ;
                else 
                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
        
    }
}