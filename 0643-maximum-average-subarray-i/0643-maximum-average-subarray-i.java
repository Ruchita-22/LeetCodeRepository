class Solution {
    public double findMaxAverage(int[] arr, int k) {
        if(arr.length < k) return -1;

        int  i = 0, j = 0;
        long ans = Long.MIN_VALUE, sum = 0;

        for( j = 0; j < k; j++) {
            sum += arr[j];
        }
        ans = Math.max(ans, sum);
        System.out.println("ans = "+ ans);
        while(j < arr.length) {
            sum = sum - arr[i] + arr[j];
            ans = Math.max(ans, sum);
            System.out.println("ans = "+ ans);
            i++; j++;
        }
        System.out.println("ans = "+ ans);

        double res = (((double)ans)/(double)k);
        return res; 
        
    }
}