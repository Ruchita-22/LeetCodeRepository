class Solution {
    //n=count1
    public int minOperations(int[] nums) {
        int count1 = 0;
        for(int num : nums) {
            if(num == 1)    count1++;
        }
        if(count1 > 0)  return nums.length - count1;
        int minOp = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            int currentGcd = nums[i];
            for (int j = i+1; j < nums.length ; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if(currentGcd == 1) {
                    minOp = Math.min(minOp, j - i);
                    break;
                }
            }
        }
        return minOp == Integer.MAX_VALUE ? -1 : minOp + nums.length-1;

    }
    private int gcd(int a, int b) {
        if(b == 0 ) return a;

        return gcd(b,a%b);
    }
}