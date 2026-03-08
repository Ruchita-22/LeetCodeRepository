class Solution {

    public int search(int[] nums, int target) {
        int m = findPointOfRotation(nums);
        if (m == 0)  // not rotated
            return binarySearch(nums, target, 0, nums.length - 1);
        if(target >= nums[0]) {
            return binarySearch(nums, target, 0, m-1);
        }
        else {
            return binarySearch(nums, target, m, nums.length-1);
        }
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
    public int binarySearch(int[] nums, int target, int l, int r) {
		int s = l, e = r;

		while (s <= e) {
			int m = s + (e - s) / 2;
			if (nums[m] == target) {
				return m;
			} else if (nums[m] < target) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		return -1;
	}
}