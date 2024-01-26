class Solution {
    //https://www.youtube.com/watch?v=ak3DkeUBo-c&list=PLpIkg8OmuX-L_QqcKB5abYynQbonaNcq3&index=49
   
    public boolean predictTheWinner(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int t[] : dp)   Arrays.fill(t, -1);
        
        int score1 = solve(0, arr.length-1, arr, dp);
        int sum = 0;
        for(int e : arr)    sum += e;
        int score2 = sum - score1;
        return score1 >= score2;
    }
    public int solve(int i, int j, int arr[], int dp[][]) {
        if(i > j)   return 0;
        if(dp[i][j] != -1)  return dp[i][j];
        int takeI = arr[i] + Math.min(solve(i+2, j, arr, dp), solve(i+1, j-1, arr, dp));
        int takeJ = arr[j] + Math.min(solve(i+1, j-1, arr, dp), solve(i, j-2, arr, dp));
        
        return dp[i][j] = Math.max(takeI, takeJ);
        
    }
}