class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        int arr[] = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++) {
            arr[i] = (nums.get(i) % mod == k) ? 1 : 0;
            System.out.println(arr[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        long count = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int sumMod = sum % mod; 
            int key = (sumMod - k + mod) % mod;
            count += map.getOrDefault(key,0);    
            map.put(sumMod, map.getOrDefault(sumMod,0)+1);
            
        }
        return count;

    }
}