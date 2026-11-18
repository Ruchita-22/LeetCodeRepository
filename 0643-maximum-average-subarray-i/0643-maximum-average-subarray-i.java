class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        long sum = 0,ans = Long.MIN_VALUE;
        int i = 0;

        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];

            if(j-i+1 == k) {
                ans = Math.max(ans, sum);
                sum -= nums[i];
                i++;
            }
            
        }
        return ans*1.0/k;
    }
}