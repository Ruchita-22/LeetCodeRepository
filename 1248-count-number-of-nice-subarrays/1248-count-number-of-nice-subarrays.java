class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0)
                arr[i] = 0;
            else 
                arr[i] = 1;
        }
        int c = countSubArrayWithSumK(arr,k);
        return c;
    }
    
    private static int countSubArrayWithSumK(int arr[], int k)
    {
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