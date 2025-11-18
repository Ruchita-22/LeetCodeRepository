class Solution {
    public int longestArithSeqLength(int[] nums) {
        int dp[][] = new int[nums.length+1][500*2+5];
        for(int t[] : dp)   Arrays.fill(t,-1);
        int n = nums.length;
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int d = nums[j] - nums[i];
                res = Math.max(res, 2 + solve(i, d, nums, dp));
            }
        }
        return res;
        
    }
    private int solve(int i, int d, int nums[], int dp[][]) {
        if(i < 0)   return 0;
        if(dp[i][d+501] != -1) return dp[i][d+501];
        int ans = 0;
        for(int k = i-1; k >= 0; k--) {
            if(nums[i] - nums[k] == d) {
                ans = Math.max(ans, 1 + solve(k,d, nums, dp));
            }
        }
        return dp[i][d+501] = ans;
    }
}