class Solution {
    public int[][] generateMatrix(int n) {
        int mat[][] = new int[n][n];
        int t = 0, b = mat.length-1, l = 0 , r = mat[0].length-1, dir = 0, k=1;
        
        while(t <= b && l <= r){
            
            if(dir == 0){
                for(int j = l; j <= r ; j++){
                    mat[t][j] = k;
                    k++;
                } 
                t++;
            }
            else if(dir==1){
                for(int i=t; i<=b; i++) {
                    mat[i][r] = k;
                    k++;
                    
                }  
                r--;
            }
            else if(dir==2){
                for(int j = r ; j>=l ; j--) {
                    mat[b][j] = k;
                    k++;
                }   
                b--;
            }
            else if(dir==3){
                for(int i=b; i>=t; i--) {
                    mat[i][l] = k;
                    k++;
                }  
                l++;  
            }
            dir  = (dir+1) % 4;
        }
        
        return mat; 
    }
}