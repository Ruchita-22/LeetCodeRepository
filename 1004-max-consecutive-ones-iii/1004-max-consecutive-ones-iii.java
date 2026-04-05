class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int freq[] = new int[2];
        // freq[0] = freq of 0 and freq[1] = freq of 1

        int i = 0, ans  = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] == 1)    freq[1]++;
            else    freq[0]++;
            while(freq[0] > k) {
                if(nums[i] == 0)    freq[0]--;
                else    freq[1]--;
                i++;
            }
            ans = Math.max(ans, j-i+1);
        }
        return ans;
    }
}