class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length < 3) return nums;
        int xor = 0;
        for(int n : nums) {
            xor ^= n;
        }
        int pos = 0;
        for(int i = 0; i < 32; i++) {
            if((xor & (1 << i)) != 0) {
                pos = i; 
                break;
            }
        }
        int set = 0, unset = 0;
        for(int n : nums) {
            if((n & (1<<pos)) != 0) unset ^= n;
            else set ^= n;
        }
        return new int[]{set,unset};
        
    }
}