class Solution {
    public int findMin(int[] nums) {
        int pov = findPointOfRotation(nums);
        return nums[pov];
    }
    public int findPointOfRotation(int[] nums) {
        int s = 0, e = nums.length - 1;

        // If array not rotated
        if (nums[s] <= nums[e]) return 0;

        while (s < e) {
            int m = s + (e - s) / 2;

            if (nums[m] > nums[e]) {
                s = m + 1;      // pivot in right half
            } else {
                e = m;          // pivot in left half incl mid
            }
        }
        return s;   // index of minimum
    }
}