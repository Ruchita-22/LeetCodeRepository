class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        int dp[][] = new int[m+1][n+1];

        for(int t[] : dp)   Arrays.fill(t, -1);

        int len =  m + n - solve(m-1, n-1, s1, s2, dp);
        System.out.println(len);
        return printSupersequence(s1,s2,dp);
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
    private String printSupersequence(String s1, String s2, int dp[][]) {

        int i = s1.length()-1, j = s2.length()-1;

        StringBuilder ans = new StringBuilder();
        while(i >= 0 && j >= 0) {

            if(s1.charAt(i) == s2.charAt(j)) {
                ans.append(s1.charAt(i));
                i--; j--;
            } // Move according to larger LCS value
            else if (i > 0 && (j == 0 || dp[i - 1][j] > dp[i][j - 1])) {
                ans.append(s1.charAt(i));
                i--;
            }
            else {
                ans.append(s2.charAt(j));
                j--;
            }
        }
        // Remaining characters
        while (i >= 0) {
            ans.append(s1.charAt(i));
            i--;
        }

        while (j >= 0) {
            ans.append(s2.charAt(j));
            j--;
        }
        return ans.reverse().toString();
    }
}