class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length < 2) return;
        rotateInRange(nums, 0, nums.length-1);
        if(nums.length < k) k = k % nums.length;
        rotateInRange(nums, 0, k-1);
        rotateInRange(nums, k, nums.length-1);
    }
    private void rotateInRange(int nums[], int i, int j) {
        while(i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++; j--;
        }
    }
}