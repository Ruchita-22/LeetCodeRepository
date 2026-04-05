class Solution {
    public int minimumCardPickup(int[] nums) {

        var map = new HashMap<Integer, Integer>();
        //map.put(0, -1);
        int i = 0, ans = Integer.MAX_VALUE;

        for(int j = 0 ; j < nums.length; j++) {
            if(map.containsKey(nums[j])) {
                ans = Math.min(ans, j-map.get(nums[j])+1);
            } 
            map.put(nums[j], j); 
        }
        return ans == Integer.MAX_VALUE || ans == nums.length-1 ? -1 : ans;
    }
}