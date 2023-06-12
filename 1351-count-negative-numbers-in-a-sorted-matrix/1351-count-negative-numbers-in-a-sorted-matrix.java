class Solution {
    public int countNegatives(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int i=0,j=mat[0].length-1;
        
        int count = 0;
        while(i< n && j>=0){
            if(mat[i][j]<0){
                count += n-i;
                j--;
            }
            else if(mat[i][j]>=0){
                i++;
            }
            
        }
        return count;
    }
}