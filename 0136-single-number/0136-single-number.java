class Solution {
    public int singleNumber(int[] arr) {
        int res = 0;
        for(int e : arr)    res ^= e;
        
        return res;
        
    }
}