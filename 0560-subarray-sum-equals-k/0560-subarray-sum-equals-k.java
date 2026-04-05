class Solution {
    public int subarraySum(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        map.put(0,1);
        int sum = 0, count = 0;
        for(int num : nums) {
            sum += num;
            if(map.containsKey(sum - k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}