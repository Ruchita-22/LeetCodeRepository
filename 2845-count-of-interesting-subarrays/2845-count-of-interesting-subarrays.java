class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int arr[] = new int[nums.size()];

        for(int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i) % modulo == k ? 1 : 0;
        }
        return solve(arr, modulo, k);    
    }
    public long solve(int[] nums, int modulo, int k) {
        var map = new HashMap<Integer, Integer>();
        map.put(0,1);
        long sum = 0, count = 0;
        for(int num : nums) {
            sum += num;
            int currMod = (int)(sum % modulo);
            int key = (int)((currMod - k) % modulo + modulo) % modulo;
            if(map.containsKey(key)) {
                count += map.get(key);
            }
            map.put(currMod, map.getOrDefault(currMod,0)+1);
        }
        return count;
    }
}