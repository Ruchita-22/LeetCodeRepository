//https://www.youtube.com/watch?v=G-i4CveBSYI&list=PLpIkg8OmuX-L_QqcKB5abYynQbonaNcq3&index=31
class Solution {
    long count;
    int mod = 1000000000+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        StringBuilder s0 = new StringBuilder();
        StringBuilder s1 = new StringBuilder();
        for(int i = 0; i < zero; i++) s0.append(0);
        for(int i = 0; i < one; i++) s1.append(1);
        
        count = 0 ;
        long dp[] = new long[high+1];
        Arrays.fill(dp,-1);
        //return solve("", low, high, new String(s0), new String(s1));
        return (int) solve(0, low, high, zero, one, dp);
        
    }

    public long solve(int len, int low, int high, int zero, int one, long dp[]) {
        if(len > high) return 0;
        if(len == high)  return 1;
        if(dp[len] != -1)   return dp[len];
        
        long left =  solve(len+zero, low, high, zero, one, dp);    
        long right = solve(len+one, low, high, zero, one, dp);
        count = left + right;
        if(low <= len && len < high) count++;
        
        return dp[len] = count % mod;
    }
    // approach 1
    /*
    public int solve(String s, int low, int high, String s0, String s1) {
        if(s.length() > high) return 0;
        if(s.length() == high)  return 1;
        int left =  solve(s+s0, low, high, s0, s1);    
        int right = solve(s+s1, low, high, s0, s1);
        count = left + right;
        if(low <= s.length() && s.length() < high) count++;
        
        return count;
    }
    */
}