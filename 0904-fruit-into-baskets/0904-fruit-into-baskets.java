class Solution {
    public int totalFruit(int[] fruits) {
        return longestSubarrayWithKUniqueCharacter(fruits, 2);
    }
    private int longestSubarrayWithKUniqueCharacter(int[] nums, int k) {
		int i = 0, ans = 0;
		var map = new HashMap<Integer, Integer>();
		for (int j = 0; j < nums.length; j++) {
			
			map.put(nums[j], map.getOrDefault(nums[j],0)+1);

			while(map.size() > k) {
				map.put(nums[i], map.get(nums[i])-1);
				if(map.get(nums[i]) == 0)	map.remove(nums[i]);
				i++;
			}
			ans = Math.max(ans,j-i+1);
		}
		return ans;
	}

}
//variation of len of the longest substring with k unique character
//pick toy varaiation