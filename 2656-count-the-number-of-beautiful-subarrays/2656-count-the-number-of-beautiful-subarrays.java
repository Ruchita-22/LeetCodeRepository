//https://www.youtube.com/watch?v=8jx35mkivJ8
class Solution {
    public long beautifulSubarrays(int[] nums) {
        int pfXor[] = new int[nums.length];
        pfXor[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            pfXor[i] = pfXor[i-1] ^ nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>(); //pfXor, frequency
        long count = 0;
        map.put(0,1);
        for(int i = 0; i < pfXor.length; i++) {
            if(map.containsKey(pfXor[i])) {
                count += map.get(pfXor[i]);
            } 
            map.put(pfXor[i], map.getOrDefault(pfXor[i], 0) + 1);
        }
        return count;
        
    }
}