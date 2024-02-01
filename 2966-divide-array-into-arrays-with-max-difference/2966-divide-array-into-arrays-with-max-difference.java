class Solution {
    public int[][] divideArray(int[] arr, int k) {
        if(arr.length % 3 != 0) return new int[0][0];
       
        Arrays.sort(arr);
        // 1 1  3 3 4 5 7 8 9 
        int  idx = -1;
        int res[][] = new int[arr.length/3][3];
        for(int i = 0; i < arr.length; i = i+3) {
           
            int t[] = new int[3];
            t[0] = arr[i];
            t[1] = arr[i+1];
            t[2] = arr[i+2];
            if (t[2] - t[0] > k) return new int[0][0];
            //if (idx > -1 && res[idx][2] == t[0]) return new int[0][0];
            res[++idx] = t;
        }
        return res;
        
    }
}