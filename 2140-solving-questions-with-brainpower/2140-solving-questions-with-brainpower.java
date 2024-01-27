class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n+1];
        Arrays.fill(dp, -1);
        
        return solve(0, questions, dp);
    }
    public long solve(int i, int[][] questions, long dp[]) {
        if(i >= questions.length)    return 0;
        
        if(dp[i] != -1) return dp[i];
        
        // take, not take
        long take = questions[i][0] + solve(i + questions[i][1] +1, questions, dp);
        long notTake = solve(i + 1, questions, dp);
            
        return dp[i] = Math.max(take, notTake);
    }
    
}