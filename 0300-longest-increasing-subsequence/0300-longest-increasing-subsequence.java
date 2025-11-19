class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int t[] : dp)   Arrays.fill(t,-1);
        return solve(0, -1, nums, dp);
    }

    private int solve(int curr, int prev, int arr[], int dp[][]) {

        if(curr == arr.length) return 0;
        if(prev >= 0 && dp[curr][prev] != -1)    return dp[curr][prev];
        int take = 0;
        //take 
        if(prev == -1 || arr[curr] > arr[prev]) {
            take = 1 + solve(curr+1, curr, arr, dp);
        }
        int notTake = 0 + solve(curr+1, prev, arr, dp);
        
        int ans = Math.max(take, notTake);
        
        if(prev != -1)  
            dp[curr][prev] = ans;
        return ans;  
    }
}