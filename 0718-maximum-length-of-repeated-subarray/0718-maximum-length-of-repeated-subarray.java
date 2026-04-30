class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        return longestCommonSubstring(nums1, nums2);
    }
    int ans = 0;
    public int longestCommonSubstring(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        
        int dp[][] = new int[m+1][n+1];

        for(int t[] : dp)   Arrays.fill(t, -1);
        
        ans = 0;
        solve(m-1, n-1, nums1, nums2, dp);
        return ans;
    }
    private int solve(int i, int j, int[] nums1, int[] nums2, int dp[][]) {
        if(i < 0 || j < 0)  return 0;

        if(dp[i][j] != -1)  return dp[i][j];
        
        if(nums1[i] == nums2[j]) {
            dp[i][j] = 1 + solve(i-1, j-1, nums1, nums2, dp);
            ans = Math.max(ans, dp[i][j]);
        } else {
            dp[i][j] = 0;
        }  
        solve(i-1, j, nums1, nums2, dp);
        solve(i, j-1, nums1, nums2, dp);  
        
        return dp[i][j];
    }
}