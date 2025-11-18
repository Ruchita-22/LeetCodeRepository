class Solution {
    /*
    diff = target
    s1+s2 = sum
    s1-s2 = diff
    s1 = sum+diff / 2

    
     */
    public int findTargetSumWays(int[] nums, int diff) {
        diff = Math.abs(diff);
        int sum = 0 , count0 = 0;
        for(int n : nums) {
            sum += n;
            if(n == 0) count0++;
        }    
        int targetSum = sum + diff;
        if( sum < diff || targetSum % 2 != 0) return 0;
        targetSum = targetSum/2;
        int dp[][] = new int[nums.length+1][targetSum+1];
        for(int t[] : dp) {
            Arrays.fill(t,-1);
        } 
        int[] arr = Arrays.stream(nums).filter(x -> x != 0).toArray();
        return solve(arr.length-1, targetSum, arr,dp) * (1 << count0);
        
    }
    private int solve(int n, int sum, int nums[], int dp[][]) {
        if(sum == 0)    return 1;
        if(n < 0)  return 0;
        if(dp[n][sum] != -1)    return dp[n][sum];

        if(sum >= nums[n])  return dp[n][sum] = solve(n-1,sum-nums[n], nums, dp) + solve(n-1, sum, nums, dp);
        else return dp[n][sum] = solve(n-1, sum, nums, dp);

        

    }
}