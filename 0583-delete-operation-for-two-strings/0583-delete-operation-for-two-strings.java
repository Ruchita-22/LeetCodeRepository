class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int t[] : dp)   Arrays.fill(t,-1);

        int lcs =  solve(word1, word2, word1.length(), word2.length(), dp);
        return word1.length() + word2.length() - (2*lcs);
        
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