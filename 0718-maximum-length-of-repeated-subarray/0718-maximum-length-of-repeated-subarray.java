class Solution {
    int ans = 0;

    public int findLength(int[] arr1, int[] arr2) {
        ans = 0;
        int dp[][] = new int[arr1.length+1][arr2.length+1];
        for (int[] t : dp) Arrays.fill(t, -1);

        solve(arr1, arr2, arr1.length, arr2.length, dp);
        return ans;
    }

    private int solve(int arr1[], int arr2[], int m, int n, int dp[][]) {
        if (m == 0 || n == 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        if (arr1[m-1] == arr2[n-1]) {
            dp[m][n] = 1 + solve(arr1, arr2, m-1, n-1, dp);
            ans = Math.max(ans, dp[m][n]);
        } else {
            dp[m][n] = 0; 
        }

        
        solve(arr1, arr2, m-1, n, dp);
        solve(arr1, arr2, m, n-1, dp);

        return dp[m][n];
    }
}
