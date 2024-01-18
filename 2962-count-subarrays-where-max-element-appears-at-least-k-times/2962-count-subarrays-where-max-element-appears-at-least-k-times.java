class Solution {
    public long countSubarrays(int[] arr, int k) {
        int maxE = -1, f = 0; 
        for(int e : arr) {
            if(e > maxE) {
                maxE = e;
                f=1;
            } else if (e == maxE) { 
                f++;               
            }                       
            else {  
            }   
        }
        
        if(f<k) return 0;
        
        int i = 0, j = 0;
        long count = 0, freq = 0;
        while(j < arr.length) {
            if(arr[j] == maxE) {
                freq++;
            }
            while(freq == k){
                count += arr.length - j;
                if(arr[i] == maxE)  freq--;
                i++;
            }
            j++;
            
        }
        return count;
        
    }
}