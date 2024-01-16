class Solution {
    public int[] singleNumber(int[] arr) {
        int res = 0;
        
        for(int e : arr)    res ^= e;
        
        int pos = 0; 
        for(int i = 0; i < 32; i++) {
            if(((res>>i)&1)==1) {
                pos = i;
                break;
            }
        }
        int set = 0, unset = 0;
        
        for(int  e : arr) {
            if(((e >> pos) & 1) == 1) set ^= e;
            else unset ^= e;
        }
        return new int[]{set, unset};
        
    }
}