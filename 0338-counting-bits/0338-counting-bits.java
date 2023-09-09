class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        for(int i = 0; i <= n; i++){
            res[i] = countBit(i);
        }
        return res;
        
    }
    private static int countBit(int n){
        int count = 0;
        for(int i = 0; i < 32; i++){
             if(checkBit(i, n)){
                 count++;
             }
        }
        return count;
    }
    private static boolean checkBit(int i, int n){
        if(((n>>i) & 1) == 1) return true;
        return false;
        
    }
}