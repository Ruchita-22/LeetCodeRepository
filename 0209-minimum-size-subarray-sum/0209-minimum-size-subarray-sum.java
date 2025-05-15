class Solution {
    public int minSubArrayLen(int target, int[] arr) {

        int i = 0, j = 0, currSum = 0, len  = Integer.MAX_VALUE;

        while (j < arr.length) {

            currSum += arr[j];
            
            if(currSum < target) {
                j++;
            } else {
                System.out.println("sum="+currSum);
                
                while(currSum >= target) {
                    len = Math.min(len, j-i+1);
                    System.out.println("len="+len);
                    currSum -= arr[i];
                    i++;;
                }
                j++;
            }
        }
        // if(currSum >= target) {
        //     len = Math.min(len, j-i+1);
        // }
        return len == Integer.MAX_VALUE ? 0 : len;
        
    }
}