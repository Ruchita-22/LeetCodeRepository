class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int dp[][] = new int[satisfaction.length+1][satisfaction.length+1];
        for(int t[] : dp) {
            Arrays.fill(t,-1);
        } 
        return solve(0, 1, satisfaction, dp);
    }
    private int solve(int n, int time, int nums[], int dp[][]) {
        if(n == nums.length)  return 0;
        if(dp[n][time] != -1)    return dp[n][time];

        return dp[n][time] = Math.max(nums[n] * time  + solve(n+1,time+1, nums, dp) , solve(n+1, time, nums, dp));
    }
}