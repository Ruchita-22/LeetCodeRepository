class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        return solve(n);
    }
    static int dp[] = new int[9];
    private static int solve(int n){
        dp[0] = 1;
        dp[1] = 10;
        int c = 9;
        int val = 9;
        for(int i=2; i<= n; i++){
            dp[i] = dp[i-1] + c * val;
            val = c * val;
            c--;
        }
        return dp[n];
    }
}