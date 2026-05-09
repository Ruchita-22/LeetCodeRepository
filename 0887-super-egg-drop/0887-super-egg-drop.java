class Solution {
    public int superEggDrop(int k, int n) {
        int dp[][] = new int[k+1][n+1];
        for(int t[] : dp)   Arrays.fill(t, -1);
        

        return solve(k, n, dp); // egg, floor
    }

    private int solve(int i, int j, int dp[][]) {
         if(j == 0 || j == 1 || i == 1)    return j;

        if(dp[i][j] != -1)  return dp[i][j];

        int ans = Integer.MAX_VALUE;
        int s = 1, e = j;
        while(s < e) {
            int k = s + (e-s)/2;

            // if egg break
            int case1 = dp[i-1][k-1] != -1 ? dp[i-1][k-1] : solve(i-1, k-1, dp);
            dp[i-1][k-1] = case1;
            
            // if egg not break
            int case2 = dp[i][j-k] != -1 ? dp[i][j-k] : solve(i, j-k, dp);
            dp[i][j-k] = case2;

            int cost = 1 + Math.max(case1, case2);
            
            ans = Math.min(ans, cost);

            if(case1 == case2)  break;
            else if(case1 < case2) s = k+1;
            else e = k;

        }
        

        return dp[i][j] = ans;
    }
}