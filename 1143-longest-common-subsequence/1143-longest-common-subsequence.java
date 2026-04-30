class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        
        int dp[][] = new int[m+1][n+1];

        for(int t[] : dp)   Arrays.fill(t, -1);

        return solve(m-1, n-1, s1, s2, dp);
    }
    private int solve(int i, int j, String s1, String s2, int dp[][]) {
        if(i < 0 || j < 0)  return 0;

        if(dp[i][j] != -1)  return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + solve(i-1, j-1, s1, s2, dp);
        } else {
            return dp[i][j] = Math.max(solve(i-1, j, s1, s2, dp), solve(i, j-1, s1, s2, dp));
        }    
    }
}