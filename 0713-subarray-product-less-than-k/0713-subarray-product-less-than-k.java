class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int i = 0, j = 0;
        long prod = 1;
        int count = 0;
        while ( j < nums.length) {
            prod = prod * nums[j];
            
            if(prod >= k) {
                while(prod >= k) {
                    prod = prod / nums[i];
                    i++;
                }
            } 
            count += j-i+1;
            j++; 
        }
        return count;
    }
}