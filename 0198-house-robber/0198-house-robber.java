class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solveMem(n, arr,dp);
    }
    private static int solveMem(int n, int arr[], int dp[]){
        if(n<1) return 0;
        if(n==1)    return arr[0];
        if(dp[n] != -1) return dp[n];
        int inc = arr[n-1] + solveMem(n-2,arr,dp);
        int excl = solveMem(n-1,arr,dp);
        return dp[n] = Math.max(inc,excl);
    }
}