class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return solve(s, 0, dp);
        
    }
    private static int solve(String s, int pos, int dp[]) {
        if(pos == s.length())    return dp[pos] = 1;
        if(dp[pos] != -1 ) return dp[pos];

        int op1 = s.charAt(pos)-'0';
        int op2 = 0;
        if(pos < s.length()-1) {
            op2 = (s.charAt(pos)-'0')*10 + s.charAt(pos+1)-'0';
        }

        if(op1 == 0)    return dp[pos] = 0;

        if(op2 > 9 && op2 < 27) {
           return  dp[pos] = solve(s, pos+1, dp) + solve(s, pos+2, dp);
        } else {
            return dp[pos] = solve(s, pos+1, dp);
        }

    }
}