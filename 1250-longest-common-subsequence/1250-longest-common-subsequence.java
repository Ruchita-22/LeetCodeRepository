class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for(int t[] : dp)   Arrays.fill(t,-1);

        return solve(text1, text2, text1.length(), text2.length(), dp);
    }
    private int solve(String str1, String str2, int m, int n, int dp[][]) {
        if(m == 0 || n == 0)    return 0;
        if( dp[m][n] != -1) return dp[m][n];
        if(str1.charAt(m-1) == str2.charAt(n-1)) {
            return dp[m][n] = 1 + solve(str1, str2, m-1, n-1, dp);
        } else {
            return  dp[m][n] = Math.max(
                solve(str1, str2, m-1, n, dp),
                solve(str1, str2, m, n-1, dp)
            );
        }
    }
}