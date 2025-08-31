class Solution {
    public void setZeroes(int[][] mat) {
        HashSet<String> set = new HashSet<>();
         int m = mat.length, n = mat[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    set.add("i"+i);
                    set.add("j"+j);
                }
            }
        }       
        System.out.println(set);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(set.contains("i"+i)) {
                    mat[i][j] = 0;
                } else if(set.contains("j"+j)) {
                    mat[i][j] = 0;
                }
            }
        }       
        
    }
}
/*
Create a set 
update the value */