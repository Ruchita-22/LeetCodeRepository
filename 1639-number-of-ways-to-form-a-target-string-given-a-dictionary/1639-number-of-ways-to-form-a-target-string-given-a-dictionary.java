class Solution {
    int m, n;
    int mod = 1000000000+7;
    public int numWays(String[] words, String target) {
        m = words.length;
        n = words[0].length();
        int freq[][] = new int[26][n+1];
        
        for(String s : words) {
            for(int j = 0; j < words[0].length(); j++) {
                char c = s.charAt(j);
                freq[c-'a'][j]++;       
            }    
        }
        long dp[][] = new long[target.length()+1][n+1];
        for(long t[] : dp) Arrays.fill(t, -1);
        return (int)(solve(0,0, freq, words, target, dp)%mod);
    }
    public long solve(int i, int j, int freq[][], String[] words, String target, long dp[][]) {
        if(i == target.length())    return 1;
        if(j == words[0].length())  return 0;
        if(dp[i][j] != -1)  return dp[i][j];
        
        long notTake = solve(i, j+1, freq, words, target, dp);
        long take = freq[target.charAt(i)-'a'][j] * 1L * solve(i+1, j+1, freq, words, target, dp)% mod;
        return dp[i][j] = (take + notTake)%mod;
    }
}