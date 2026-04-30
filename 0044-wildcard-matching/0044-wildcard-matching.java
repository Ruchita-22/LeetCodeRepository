class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        
        int dp[][] = new int[m+1][n+1];

        for(int t[] : dp)   Arrays.fill(t, -1);

        return solve(m-1, n-1, s, p, dp);
    }

    private boolean solve(int i, int j, String s1, String s2, int dp[][]) {
        if(i < 0 && j < 0)  return true;    // both exhausted
        if(j < 0) return false;     // pattern exhaused but str left
        if(i < 0 ) {                    
            for(int idx = 0; idx <= j; idx++) {
                if(s2.charAt(idx) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != -1)  return dp[i][j] == 1 ? true : false;
        boolean ans = false;

        if(s1.charAt(i) == s2.charAt(j)) {
           ans = ans || solve(i-1, j-1, s1, s2, dp);
        } else if(s2.charAt(j) == '?') {
            ans = ans || solve(i-1, j-1, s1, s2, dp);
        }else if(s2.charAt(j) == '*') {
            ans = ans || solve(i, j-1, s1, s2, dp)|| solve(i-1, j, s1, s2, dp);
        } else {
            ans = ans || false;
        }   
        dp[i][j] = ans == true ? 1 : 0;
        return ans;
    }
}