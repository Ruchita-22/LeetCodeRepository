class Solution {
    public String stoneGameIII(int[] stoneValue) {
        // int n = stoneValue.length;
        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);

		//int ans = solve(0, stoneValue,dp);
        int ans = solveTab(stoneValue);

		if(ans>0)	return "Alice";
		else if(ans==0)	return "Tie";
		else return "Bob";
    }
	private static int solve(int i, int[] arr, int dp[]) {
		int n = arr.length;
		if(i >= n)	return 0;
        if(dp[i] != -1) return dp[i];

		int ans = Integer.MIN_VALUE;
		int case1 = arr[i] - solve(i+1, arr,dp);
		int case2 = i+1 < n ? arr[i]+arr[i+1] - solve(i+2, arr,dp) : Integer.MIN_VALUE;
		int case3 = i+2 < n ?  arr[i]+arr[i+1]+arr[i+2] - solve(i+3, arr,dp) : Integer.MIN_VALUE;
		ans = Math.max(case1, Math.max(case2, case3));
		return dp[i] = ans;
	}
    private static int solveTab(int[] arr) {
		int n = arr.length;
		int dp[] = new int[n+1];
		dp[n] = 0;
		int ans = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--) {
    		int case1 = arr[i] - dp[i+1];
    		int case2 = i+1 < n ? arr[i]+arr[i+1] - dp[i+2] : Integer.MIN_VALUE;
    		int case3 = i+2 < n ?  arr[i]+arr[i+1]+arr[i+2] - dp[i+3] : Integer.MIN_VALUE;
    		ans = Math.max(case1, Math.max(case2, case3));
    		dp[i] = ans;
        }
        return dp[0];
		
	}
}