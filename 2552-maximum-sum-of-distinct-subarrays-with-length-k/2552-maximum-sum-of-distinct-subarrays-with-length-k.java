class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        if(arr.length < k)  return 0;

        HashMap<Integer,Integer> map  = new HashMap<>();
        long ans = 0, sum = 0;

        // First window;
        int i = 0, j = 0;
        for(j = 0; j < k; j++) {
            sum += arr[j];
            if(!map.containsKey(arr[j])) {
                map.put(arr[j],1);
            } else {
                map.put(arr[j], map.get(arr[j])+1);
            }   
        }
        if(map.size() == k) ans = Math.max(ans,sum);

        // slide window
        while( j < arr.length) {

            sum -= arr[i];
            map.put(arr[i], map.get(arr[i])-1);
            if(map.get(arr[i]) == 0) map.remove(arr[i]);

            sum += arr[j];
            if(!map.containsKey(arr[j])) {
                map.put(arr[j],1);
            } else {
                map.put(arr[j], map.get(arr[j])+1);
            }
            if(map.size() == k) ans = Math.max(ans,sum);
            i++; j++;
        }
        return ans;
        
    }
}