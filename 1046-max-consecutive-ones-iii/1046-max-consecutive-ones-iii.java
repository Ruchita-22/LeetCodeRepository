class Solution {
    public int longestOnes(int[] arr, int k) {
        //int c0 = 0, c1 = 0;

        // for(int e : arr) {
        //    if(e == 0)   c0++;
        //    else c1++;
        // }

        //if(c0 < k)  return arr.length;
        
        int i = 0, j = 0, len = 0, count1 = 0, count0 = 0;
        
        while(j < arr.length) {
            
            if(arr[j] == 1) j++;
            else if(arr[j] == 0) {
                count0++;
                j++;
            }
            else {

            }
            if(count0 > k) {
                len = Math.max(len, j-i-1);
                while(count0 > k) {
                    if(arr[i] == 1) i++;
                    else {
                        count0--;
                        i++;
                    }
                }
                
            }
        }
        len = Math.max(len, j-i);
        return len;
    }        
        
}