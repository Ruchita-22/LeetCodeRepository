class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int freq[] = new int[2];
        //freq[0] = 0, freq[1] = 1;
        int i = 0, j = 0;
        while ( j < nums.length) {
            if(nums[j] == 1) freq[1]++;
            else freq[0]++;
            // we can only flip 
            while(freq[0] > k) {
                if(nums[i] == 1) freq[1]--;
                else freq[0]--;
                i++;
            }
            res = Math.max(res, j-i+1);
            j++;
        }
        return res;
    }
}