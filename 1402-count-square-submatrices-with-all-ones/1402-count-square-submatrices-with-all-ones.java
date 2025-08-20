class Solution {
    public int countSquares(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int dp[][] = new int[m+1][n+1];
        for(int t[] : dp)   Arrays.fill(t, -1);
        
        int count = 0;
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    count += solve(i, j, mat, dp);
                }
            }
        }
        return count;
    }
    private static int solve(int i, int j, int mat[][], int dp[][]) {
        if(! isValid(i,j, mat) || mat[i][j] == 0)   return 0;
        
        if(dp[i][j] != -1)  return dp[i][j];
        
        int x = 1 + solve(i+1, j, mat, dp);
        int y = 1 + solve(i, j+1, mat, dp);
        int z = 1 + solve(i+1, j+1, mat, dp);
        return dp[i][j] = Math.min(x, Math.min(y,z));
    }
    private static boolean isValid(int i, int j, int arr[][]) {
        int m = arr.length;
        int n = arr[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n)  return false;
        else return true;
    }
}