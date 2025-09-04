class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // modulo, idx
        map.put(0,-1);

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum % k)) {
                int len = i - map.get(sum % k);
                if(len >= 2)    
                    return true;
            } else {
                map.put(sum % k, i);
            }
            //System.out.println(map);
        }
        return false;
        
    }
 
}