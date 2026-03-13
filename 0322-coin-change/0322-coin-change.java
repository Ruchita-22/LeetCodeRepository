class Solution {
    public int coinChange(int[] coins, int amount) {
          int dp[] = new int[amount+1];
        Arrays.fill(dp,-1);
        int ans = solve(coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(int[] coins, int amount, int dp[]) {
        if(amount < 0)   return Integer.MAX_VALUE;
        if(amount == 0)  return 0;

        if(dp[amount] != -1) return dp[amount];

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            if(amount >= coins[i]) {
                int res = solve(coins, amount-coins[i], dp);
                if(res != Integer.MAX_VALUE)
                    ans = Math.min(ans, 1 + res);
            }
        }
        return dp[amount] = ans;
    }
}