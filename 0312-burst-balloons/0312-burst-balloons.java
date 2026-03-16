class Solution {
    public int maxCoins(int[] arr) {
        int n = arr.length;
        int nums[] = new int[n+2];
        nums[0] = 1;
        nums[n+1] = 1;
        int i = 1;
        for(int e : arr) {
            nums[i++] = e;
        }
        n = nums.length;
		int dp[][] = new int[n + 1][n + 1];
		for (int t[] : dp)
			Arrays.fill(t, -1);
        return solve(1, arr.length, nums, dp);
    }

	private static int solve(int i, int j, int arr[], int dp[][]) {

		if (i > j)      
            return 0;
        if (dp[i][j] != -1)     
            return dp[i][j];
        int ans = 0;
		for (int k = i; k <= j; k++) {
			int temp = solve(i, k-1, arr, dp) + solve(k + 1, j, arr, dp) + arr[i - 1] * arr[k] * arr[j+1];
			ans = Math.max(ans, temp);

		}
		return dp[i][j] = ans;

	}
}