class Solution {
    //static int res = 0;
    public int integerBreak(int n) {
        //res = 0;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
     
    }
    public int solve(int n, int dp[]) {
        
        if(n == 1)  return 1;
        if(dp[n] != -1) return dp[n];
        int res = Integer.MIN_VALUE;
        int prod = 1*(n-1);
        for(int i = 1; i < n; i++) {
            prod =  i * Math.max(n-i, solve(n-i, dp));
            res = Math.max(res, prod);
        }
        return dp[n] = res;
    }
}