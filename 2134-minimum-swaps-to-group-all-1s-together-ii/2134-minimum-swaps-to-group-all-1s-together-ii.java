class Solution {
    public int minSwaps(int[] arr) {
        int k = 0;      // window size
        for(int e : arr) {
            if(e == 1) k++;
        }
        int res[] = new int[2*arr.length];
        for(int i = 0; i < arr.length; i++){
            res[i] = arr[i];
            res[i+arr.length] = arr[i];
        }
        int minZero = Integer.MAX_VALUE, currMinZero = 0;
        int i = 0, j = 0;
        for(j = 0; j < k ; j++) {
            if(res[j] == 0) currMinZero++;
        }
        minZero = Math.min(minZero, currMinZero);
        
        while(j < res.length) {
            if(res[j] == 0) currMinZero++;
            if(res[i] == 0) currMinZero--;
            i++; j++;
            minZero = Math.min(minZero, currMinZero);
        }
        return minZero;
      
    }
}