class Solution {
    public int maxSubarrayLength(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k == 0)    return 0;
        
        Map<Integer, Integer> map = new HashMap();
        int maxLen = 0;
        int i = 0, j = 0;
        while(j < arr.length) {
            
            if(!map.containsKey(arr[j]) || map.get(arr[j]) < k) {
                map.put(arr[j], map.getOrDefault(arr[j],0)+1);
                j++;
            } else {
                maxLen = Math.max(maxLen, j-i);
                    
                while(map.containsKey(arr[j]) && map.get(arr[j]) >= k) {
                    map.put(arr[i], map.get(arr[i])-1);
                    if(map.get(arr[i]) == 0) map.remove(arr[i]);
                    i++;
                }  
            }
        }
        maxLen = Math.max(maxLen, j-i);
        return maxLen;
    }
}