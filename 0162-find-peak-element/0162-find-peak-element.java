class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if(nums.length == 1)    return 0;
        if(nums[0] > nums[1])   return 0;
        if(nums[n-1]> nums[n-2])    return n-1;

        int s = 1, e = nums.length - 2;

		while (s <= e) {
			int m = s + (e - s) / 2;
			if (nums[m] > nums[m-1] && nums[m] > nums[m+1]) {
				return m;
			} else if (nums[m] > nums[m-1] && nums[m] < nums[m+1]) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		return -1;
    }
}