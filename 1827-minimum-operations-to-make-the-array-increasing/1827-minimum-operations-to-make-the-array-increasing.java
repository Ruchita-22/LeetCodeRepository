class Solution {
    public int minOperations(int[] nums) {
        int j = 1, prev = nums[0], op = 0;
        while(j < nums.length) {
            if(prev >= nums[j]) {
                prev++;
                op += (prev - nums[j]);
            } else {
                prev = nums[j];
            }
            j++;
        }
        return op;
    }

}