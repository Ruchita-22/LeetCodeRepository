class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int dp[][][] = new int[2][n+1][n+1];
        for(int t[][] : dp) {
            for(int t1[] : t) {
                Arrays.fill(t1, -1);
            }
        }
        return solve(1, 0, 1, piles, dp);
    }
    private static int solve(int turn, int i, int m, int arr[], int dp[][][]) {
        if(i >= arr.length) return 0;
        if(dp[turn][i][m] != -1)    return dp[turn][i][m];
        
        int res = turn == 1 ? -1  : Integer.MAX_VALUE;
        int stone = 0;
        
        for(int x = 1; x <= Math.min(2*m, arr.length - i); x++){
            stone += arr[i+x-1];
            if(turn == 1) { // alice
                res = Math.max(res, stone + solve(0, i+x, Math.max(m,x), arr, dp));
            } else {
                res = Math.min(res, solve(1, i+x, Math.max(m,x), arr, dp));
            }
        }
        return dp[turn][i][m] = res;
    }
}