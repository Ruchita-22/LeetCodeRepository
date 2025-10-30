class Solution {
    public long countGood(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        int i = 0, j = 0; 
        long pairs = 0;
        long ans = 0;
        while(j < nums.length) {
            pairs += map.getOrDefault(nums[j],0);
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);

            if(pairs >= k) {
                while(pairs >= k) {
                    map.put(nums[i], map.get(nums[i])-1);
                    pairs -= map.get(nums[i]);
                    ans += nums.length-j;
                    i++;
                }
            }
            j++;
            //System.out.println(map+" pairs = "+ pairs +" ans = "+ans);
            
        }
        return ans;
        
    }
}