class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int res = 0;
        for(int e : arr)    res ^= e;
        for(int i = 0; i<= n; i++)   res ^= i;
        
        return res;
        
    }
}