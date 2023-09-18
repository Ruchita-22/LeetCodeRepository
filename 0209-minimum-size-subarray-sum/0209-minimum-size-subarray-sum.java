class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int tSum = 0;
        for(int e : arr){
            tSum += e;
        }
        if(tSum < target)   return 0;
        
        int len = arr.length;
        
        int i = 0, j = 0, sum = 0;
        
        while(j < arr.length){
            sum += arr[j];
            if(sum < target)    j++;
            else if(sum >= target){
                len = Math.min(len, j-i+1);
                while(sum >= target){
                    sum -= arr[i];
                    i++;
                    if(sum >= target){
                        len = Math.min(len, j-i+1);
                    }
                    
                }
                j++;
            }
        }
        return len;
    }
}