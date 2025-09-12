class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int res[] = new int[]{-1, -1};

        // first search first
        while(l <= r) {
            int m = l + (r-l)/2;
            if(nums[m] == target) {
                res[0] = m;
                r = m -1;
            } else if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        l = 0;
        r = nums.length-1;
        // search last
        while(l <= r) {
            int m = l + (r-l)/2;
            if(nums[m] == target) {
                res[1] = m;
                l = m + 1;
            } else if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
        
    }
}