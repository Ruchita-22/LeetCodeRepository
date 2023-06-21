class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int idx = n % 2 == 0 ? n/2 : n/2 + 1;
        int center = nums[idx-1];
        int cost = 0;
        
        for(int num : nums){
            cost += Math.abs(num - center);
        }
        return cost;
        
    }
}