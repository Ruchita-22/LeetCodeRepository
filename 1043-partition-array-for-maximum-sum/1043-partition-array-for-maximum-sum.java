class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n + 1];

        Arrays.fill(dp, -1);
        return solve(0, k, arr, dp);
    }

    private int solve(int i, int k, int arr[], int dp[]) {

        if (i == arr.length)    return 0;
        if (dp[i] != -1)     return dp[i];

        int max = 0, ans = 0;
        for (int j = i; j < Math.min(i+k, arr.length); j++) {
            max = Math.max(max,arr[j]);
            int sum =  (j-i+1) * max + solve(j + 1, k, arr, dp)  ;
            ans = Math.max(ans,sum);

        }
        return dp[i]= ans;

    }
}