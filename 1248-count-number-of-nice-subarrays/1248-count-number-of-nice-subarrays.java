class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int arr[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] % 2 == 0 ? 0 : 1;
        }
        return solve(arr, k); 
    }
    
    public int solve(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        map.put(0,1);

        int sum = 0, count = 0;
        for(int num : nums) {
            sum += num;
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}