class Solution {
    static int mod = 1000000000+7;
    public int kInversePairs(int n, int k) {
       long dp[][] = new long[n+1][k+1]; 
        for(long t[] : dp) Arrays.fill(t, -1);
        
       return (int)(solve(n, k, dp) % mod); 
        
    }
    public long solve(int n, int k, long dp[][]) {
        if (n == 0) return 0; 
        if (k == 0)  return 1;
        if(dp[n][k] != -1)  return dp[n][k];
        long res = 0;
        for(int inv = 0; inv <= Math.min(k,n - 1); inv++) {
            res += solve(n-1, k - inv, dp) % mod;
        }
        return dp[n][k] = res;
    }
}