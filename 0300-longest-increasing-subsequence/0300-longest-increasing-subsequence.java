class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
		int dp[][] = new int[n+1][n+1];
        for(int t[] : dp)   Arrays.fill(t, -1);
		return solve1(0, -1, arr, dp) ;	
    }
    
    private static int solve1(int i, int prev_i, int arr[], int dp[][]) {
		if(i == arr.length)	return 0;
		if(dp[i][prev_i+1] != -1)	return dp[i][prev_i+1];
		
		int len = 0 + solve1(i+1, prev_i, arr, dp);
		if(prev_i == -1 || arr[i] > arr[prev_i]) {
			len = Math.max(len, 1 + solve1(i+1, i, arr, dp));
		}
		return dp[i][prev_i+1] = len;
	}
}