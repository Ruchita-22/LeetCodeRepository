class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        // int count = n&(n-1);

        // for(int i = 0; i < 32; i++) {
        //     if((n & (1<<i)) != 0) {
        //         count++;
        //     }    
        // }
        return (n&(n-1)) == 0;
        
    }
}