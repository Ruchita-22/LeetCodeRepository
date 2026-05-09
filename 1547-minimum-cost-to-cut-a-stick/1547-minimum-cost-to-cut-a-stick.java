class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        // to make the scale
        int arr[] = new int[cuts.length+2];
        arr[0] = 0;
        arr[arr.length-1] = n;

        int i = 1;
        for(int cut :cuts) {
            arr[i++] = cut;
        } 

        
        int dp[][] = new int[arr.length+2][arr.length+2];
        for(int t[] : dp)   Arrays.fill(t, -1);

        return solve(0, arr.length-1, arr, dp); 
    }
    private int solve(int i, int j, int arr[], int dp[][]) {

        if(j-i < 2)  return 0;

        if(dp[i][j] != -1)  return dp[i][j];

        int ans = Integer.MAX_VALUE;
        // cuts start with 1 and j-1
        for(int k = i+1; k <= j-1; k++) {
            int left = solve(i, k, arr, dp);
            int right = solve(k, j, arr, dp);
            int cost = arr[j] - arr[i] + left + right;
            
            ans = Math.min(ans, cost);
        }
        return dp[i][j] = ans;
    }
}