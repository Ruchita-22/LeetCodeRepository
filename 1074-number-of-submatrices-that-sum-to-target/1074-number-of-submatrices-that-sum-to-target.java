class Solution {
    public int numSubmatrixSumTarget(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        long res[][] = pfConstruct1(mat);
        int count = 0;
        for (int i1 = 0; i1 < n; i1++) {
			for (int j1 = 0; j1 < m; j1++) {
				for (int i2 = i1; i2 < n; i2++) {
					for (int j2 = j1; j2 < m; j2++) {
                        
                        long sum = res[i2][j2];
                        if(i1>0)    sum -= res[i1-1][j2];
                        if(j1>0)    sum -= res[i2][j1-1];
                        if(i1>0 && j1>0)    sum += res[i1-1][j1-1];
                        
                        if(sum == target)   count++;
                    }   
                }
            }
        }
        return count;
    }
    private static long[][] pfConstruct1(int mat[][]){
        int n = mat.length;
        int m = mat[0].length;
        long res[][] = new long[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j] = j==0 ? mat[i][j] : res[i][j-1]+mat[i][j]; 
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j] = i==0 ? res[i][j] : res[i-1][j]+res[i][j]; 
            }
        }
        return res;
    }
}