class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if(arr == null || arr.length == 0)  return 0;
        //if(threshold == 0)  return arr.length;
        
        int i = 0, j = 0;
        int count = 0;
        
        int sum = 0;
        for(j = 0; j < k; j++){
            sum += arr[j];
        }
        if(sum/k >= threshold) count++;
        
        while(j < arr.length) {
            sum = sum + arr[j] - arr[i];
            j++; i++;
            if(sum/k >= threshold) count++;
            
        }
        return count;
        
        
    }
}