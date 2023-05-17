class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        int i=0, j=0;
        while(i<n && j<n){
            sum += mat[i][j];
            i++;
            j++;
            
        }
        
        i=0;
        j = n-1;
        while(i<n && j>=0){
            if(i==j && n%2==1){
                
            }
            else{
                sum += mat[i][j];
            }
            i++; j--;
        }
        return sum;
    }
}