class Solution {
    public int minOperations(int[] nums, int x) {
        // edge case
        long totalSum = 0;
        for(int num : nums) totalSum += num;
        if(x > totalSum)   return -1;

        long targetSum = totalSum - x;
        System.out.println("targetSum = "+ targetSum);
        if(targetSum == 0)  return nums.length;
        
        int ws = solve(nums, targetSum);
        return ws == 0 ? -1 : nums.length-ws;  
    }
    private int solve(int nums[], long target) {
        int i = 0, ans = 0;
        long sum = 0;
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            
            while(sum > target) {
                sum -= nums[i];
                i++;
            }

            if(sum == target) ans = Math.max(ans, j-i+1);
        }
        return ans;
    }
}
