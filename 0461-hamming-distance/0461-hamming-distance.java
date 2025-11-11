class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int ans =  x ^ y;
        for(int i = 0; i < 32; i++) {
            if((ans & (1<<i)) != 0)  count ++;
        }
        return count;
    }
}