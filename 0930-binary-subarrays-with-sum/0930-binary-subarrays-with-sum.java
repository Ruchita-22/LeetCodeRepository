class Solution {
    public int numSubarraysWithSum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();        // sum freq
        map.put(0,1);
        
        int sum = 0, count = 0;
        for(int e : arr){
            sum += e;
            int removeSum = sum - k;
            if(map.containsKey(removeSum)){
                count += map.get(removeSum);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;  
    }
}