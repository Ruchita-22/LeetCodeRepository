class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> list = new ArrayList<>();
        
        int t = 0, b = mat.length-1, l = 0 , r = mat[0].length-1, dir = 0;
        
        while(t <= b && l <= r){
            
            if(dir == 0){
                for(int j = l; j <= r ; j++) list.add(mat[t][j]);
                t++;
            }
            else if(dir==1){
                for(int i=t; i<=b; i++)   list.add(mat[i][r]);
                r--;
            }
            else if(dir==2){
                for(int j = r ; j>=l ; j--) list.add(mat[b][j]);
                b--;
            }
            else if(dir==3){
                for(int i=b; i>=t; i--)   list.add(mat[i][l]);
                l++;  
            }
            dir  = (dir+1) % 4;
        }
        
        return list; 
    }
}