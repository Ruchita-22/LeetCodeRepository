class Solution {
    public int equalPairs(int[][] mat) {
        HashMap< String, Integer > map = new HashMap<>();
        for( int i = 0; i < mat.length; i++){
            String s = "";
           for(int j = 0; j < mat[0].length; j++) {
               s = s + "_" + mat[i][j];
           }
           map.put(s,map.getOrDefault(s,0)+1);   
        }
        
        int count = 0;
        for( int j = 0; j < mat.length; j++){
            String s = "";
           for(int i = 0; i < mat[0].length; i++) {
               s = s + "_" + mat[i][j];
           }
           if(map.containsKey(s)) count += map.get(s); 
        }
        
        return count;
    }
}