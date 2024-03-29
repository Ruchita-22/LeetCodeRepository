class Solution {
    public int findMiddleIndex(int[] arr) {
        // construct pf
        int pf[] = new int[arr.length];
        pf[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            pf[i] = pf[i-1] + arr[i];
        }
        for(int i = 0; i < arr.length; i++) {
            int pfLeft = 0, pfRight = 0;
            int n = arr.length;
            if(i == 0) {
                pfRight = pf[n-1] - pf[i];
            } else if(i == n-1) {
                pfLeft = pf[n-2];
            } else {
                pfLeft = pf[i - 1];
                pfRight = pf[n-1] - pf[i];
            }
            
            if(pfLeft == pfRight)   return i;
            
        }
        return -1;
        
    }
}