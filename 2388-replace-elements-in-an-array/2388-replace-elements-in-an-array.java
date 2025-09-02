class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        System.out.println(map);
        for(int i = 0; i < operations.length; i++) {
            if(map.containsKey(operations[i][0])) {
                int idx = map.get(operations[i][0]);
                nums[idx] = operations[i][1];
                map.put(nums[idx],idx);
                System.out.println(idx+" "+ nums[idx]);
            }
        }
        return nums;
        
    }
}