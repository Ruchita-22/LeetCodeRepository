class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length+1][nums.length+1];
        for(int t[] : dp)   Arrays.fill(t, -1);
        return solve(nums,nums.length, 0, -1, dp);
    }
    private int solve(int arr[], int n, int curr, int prev, int dp[][]) {
        if(curr == n)   return 0;
        if(prev != -1 && dp[curr][prev] != -1)    return dp[curr][prev];
        int take = 0;
        if(prev == -1 || arr[curr] > arr[prev]) {
            take = 1 + solve(arr, n, curr+1, curr, dp);
        } 
        int notTake = 0 + solve(arr, n, curr+1, prev, dp);
        int ans = Math.max(take, notTake);
        if(prev != -1)  
            dp[curr][prev] = ans;
        return ans;    
    }
}