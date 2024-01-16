class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
            res[i] = countSetBit(i);
        }
        return res;
    }
    public int countSetBit(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if(((n>>i) & 1) == 1) count++;
        }
        return count;
    }
}