class Solution {
    public int minOperations(int[] nums, int x) {
        long totalSum = 0;
        for(int e : nums) totalSum += e;
        if(x > totalSum)   return -1;
        long targetSum = totalSum - x;
        System.out.println("targetSum = "+ targetSum);
        if(targetSum == 0)  return nums.length;
        int ws = 0, i = 0, j = 0;
        long sum = 0;
        while(j < nums.length) {
            sum += nums[j];
            if(sum == targetSum) {
                ws = Math.max(ws, j-i+1);
            } else if(sum > targetSum) {
                while(sum > targetSum) {
                    sum -= nums[i];
                    i++;
                    if(sum == targetSum) ws = Math.max(ws, j-i+1);
                }
            }
            j++;
        }
        return ws == 0 ? -1 : nums.length-ws;  
    }
}
