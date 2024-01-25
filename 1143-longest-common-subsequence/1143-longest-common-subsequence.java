class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t, -1);
        
        return solve(m-1, n-1, s1, s2, dp);
    }
    private static int solve(int m, int n, String s1, String s2, int dp[][]) {
        if(m < 0  || n < 0)    return 0;
        if(dp[m][n] != -1)  return dp[m][n];
        
        if(s1.charAt(m) == s2.charAt(n)) {
            return dp[m][n] = 1 + solve(m-1, n-1, s1, s2, dp);
        } else {
            return dp[m][n] = Math.max(solve(m-1, n, s1, s2, dp), solve(m, n-1, s1, s2, dp));
        }
        
    }
}