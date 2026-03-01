class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        int count  = 0;
        int sum = 0;
        for(int num : nums) {
            sum += num;
            int sumMod = sum % k;
            if(sumMod < 0) sumMod = sumMod + k;
            if(map.containsKey(sumMod)) {
                count += map.get(sumMod);
            }
            map.put(sumMod, map.getOrDefault(sumMod,0)+1);
        }
        return count;
    }
}