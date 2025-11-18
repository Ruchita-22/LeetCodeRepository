class Solution {
    int N, GOAL, K, MOD = 1000000007;
    public int numMusicPlaylists(int n, int goal, int k) {
        N = n;
        GOAL = goal;
        K = k;
        long dp[][] = new long[goal+1][n+1];
        for(long t[] : dp) {
            Arrays.fill(t, -1);
        }
        return (int)(solve(0,0, dp));
    }
    private long solve(int countSong, int uniqueSong, long dp[][]) {
        if(countSong == GOAL) {
            if(uniqueSong == N) return 1;
            else return 0;
        }
        if(dp[countSong][uniqueSong] != -1) return dp[countSong][uniqueSong];
        long res = 0;
        //option 1 play unique song
        if(uniqueSong < N)
        res += (N - uniqueSong) * solve(countSong + 1, uniqueSong + 1, dp);

        // option 2 replay song
        if(uniqueSong > K)
        res += (uniqueSong - K ) * solve(countSong + 1, uniqueSong, dp);

        return dp[countSong][uniqueSong] = res % MOD;

    }
}