class Solution {
    int arr[];
    Random random;
    public Solution(int[] nums) {
        arr = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        int count = 0, res = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != target)    continue;
            if(random.nextInt(++count) == 0)    res = i;
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */