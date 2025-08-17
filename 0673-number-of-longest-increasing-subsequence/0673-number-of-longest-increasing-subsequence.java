class Pair {
    int len,count;
    public Pair(int len, int count){
        this.len=len;
        this.count=count;
    }
}
class Solution {
    public int findNumberOfLIS(int[] nums) {
        Pair dp[][] = new Pair[nums.length+1][nums.length+1];
        for(Pair[] p: dp) {
            Arrays.fill(p, new Pair(-1,-1)); 
        }
        Pair ans = solve(nums, nums.length,0, -1, dp);
        return ans.count;
    }
    private Pair solve(int arr[], int n, int curr, int prev, Pair dp[][] ) {
        if(curr == n) {
            return new Pair(0,1);
        }
        if (prev != -1 && dp[curr][prev].len != -1) return dp[curr][prev];
        int len = 0, count = 0;

        if(prev == -1 || arr[curr] > arr[prev]) {
            Pair take =  solve(arr, n, curr+1, curr, dp);
            if(1+take.len > len) {
                len = 1+take.len;
                count=take.count;
            } else if(1+take.len == len) {
                count += take.count;
            }
        }
        Pair notTake = solve(arr, n, curr+1, prev, dp);
        if(notTake.len > len) {
            len = notTake.len;
            count = notTake.count;
        } else if(notTake.len == len) {
            count += notTake.count;
        }
        Pair p = new Pair(len, count);
        if(prev != -1) {
            dp[curr][prev] = p;
        }
        return p;

    }
}