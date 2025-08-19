class Solution {
    public long zeroFilledSubarray(int[] arr) {
        long ans = 0;
        long count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                if(count == 1){
                    ans += count; 
                    count = 0;
                }  
                else if(count > 1) {
                    ans += count*(count+1)/2;
                    count = 0;
                }
                    
            } else {
                count++;
            }

        }
        if(count != 0)  ans += count*(count+1)/2;
        return ans;
    }
}