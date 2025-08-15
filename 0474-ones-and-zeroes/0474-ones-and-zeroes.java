class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int dp[][][] = new int[strs.length+1][m+1][n+1];

        for(int t1[][] : dp) {
            for(int t2[] : t1) {
                Arrays.fill(t2,-1);
            }
        }
        
        
        return solve(strs, strs.length, m, n, dp);
    }
    private int solve(String[] strs, int n, int c0, int c1, int dp[][][]) {
        if(n == 0) return dp[n][c0][c1] = 0; 

        if(dp[n][c0][c1] != -1) return dp[n][c0][c1];

        int count0 = count0(strs[n-1]);
        int count1 = count1(strs[n-1]);
        if(count0 <= c0 && count1 <= c1) {
            return dp[n][c0][c1] = Math.max(1+solve(strs, n-1, c0-count0, c1-count1,dp), 
            solve(strs, n-1, c0, c1,dp));
        } else {
            return dp[n][c0][c1] = solve(strs, n-1, c0, c1, dp);
        }

    }
    private static int count0(String str){
        int c0=0;
        for(char c : str.toCharArray()) {
            if(c == '0') c0++;
        }
        
        return c0;
    }
    private static int count1(String str){
        int c1=0;
        for(char c : str.toCharArray()) {
            if(c == '1') c1++;
        }

        return c1;
    }

}