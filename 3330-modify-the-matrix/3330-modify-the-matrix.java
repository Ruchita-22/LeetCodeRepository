class Solution {
    public int[][] modifiedMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int ans[][] = new int[m][n];
        int max[] = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans[i][j] = mat[i][j];
                if(max[j] < mat[i][j]) max[j] = mat[i][j];
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(ans[i][j] == -1)
                ans[i][j] = max[j];
            }
        }
        return ans;
        
    }
}
// copy so 2 loop, 
// max value in each col, 
// replace -1
// edge casse