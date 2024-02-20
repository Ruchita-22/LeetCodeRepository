class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int i = 0;
        int xor = 0;
        boolean flag = false;
        while(i < n) {
            xor ^= i;
            if(arr[i] != n) {
                xor ^= arr[i];
            } 
            if(arr[i] == 0) flag = true;
            i++;
        }
        if(xor != 0)    return xor;
        else if(xor == 0 && flag == false)  return 0;
        else return n;
        
    }
}