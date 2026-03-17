class Solution {
   public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] arr = new int[cuts.length+2];
        arr[0] = 0;
        int i = 1;
        for(int e : cuts) {
            arr[i] = e;
            i++;
        }
        arr[i] = n;
        int dp[][]=new int[arr.length+2][arr.length+2];
        for(int t[] : dp)
            Arrays.fill(t,-1);
        return solve(0, arr.length-1, arr, dp);
    }
    private int solve(int i, int j, int cuts[], int dp[][]) {
        if(j-i < 2) return 0;
        if(dp[i][j] != -1)  return dp[i][j];
        int res = Integer.MAX_VALUE;
        for(int k = i+1; k <= j-1; k++) {
            // int left = dp[i][k] != -1 ? dp[i][k] : solve(i, k, cuts, dp);
            // int right = dp[k][j] != -1 ? dp[k][j] : solve(k, j, cuts, dp);
            int cost = (cuts[j] - cuts[i]) + solve(i, k, cuts, dp) + solve(k, j, cuts, dp);
            res = Math.min(res, cost);
        }
        return dp[i][j] = res;
    }
}