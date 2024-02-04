class Solution {
    public int numSubmatrixSumTarget(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;
        
        // construct pf
        int pf[][] = new int[m][n];
        for(int i = 0; i < m ; i++) {
            for(int j = 0 ; j < n; j++) {
                pf[i][j] = j == 0 ? mat[i][j] : pf[i][j-1] + mat[i][j];
            }
        }
        for(int i = 1; i < m ; i++) {
            for(int j = 0 ; j < n; j++) {
                pf[i][j] = pf[i-1][j] + pf[i][j];
            }
        }
        int count = 0;
        for(int a1 = 0; a1 < m ; a1++) {
            for(int b1 = 0 ; b1 < n; b1++) {
                for(int a2 = a1; a2 < m ; a2++) {
                    for(int b2 = b1 ; b2 < n; b2++) {
                        int sum = pf[a2][b2];
                        if(a1 > 0)  sum -= pf[a1-1][b2];
                        if(b1 > 0)  sum -= pf[a2][b1-1];
                        if(a1 > 0 && b1 > 0)  sum += pf[a1-1][b1-1];
                        if(sum == target) count++;
                    }
                }    
            }
        }
        return count;
    }
}