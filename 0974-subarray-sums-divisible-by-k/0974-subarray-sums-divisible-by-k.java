class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        map.put(0,1);
        int sum = 0, count = 0;

        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            int sumMod = (sum % k + k)%k;
            if(map.containsKey(sumMod)) {
                count += map.get(sumMod);
            }
            map.put(sumMod, map.getOrDefault(sumMod,0)+1);
        }
        return count;
    }
}