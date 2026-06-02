class Solution {
    private static long add(long a, long b) {
        long mod = 1000000007;
        return ((a % mod) + (b % mod) + mod) % mod;
    }
    private static long sub(long a, long b) {
        long mod = 1000000007;
        return ((a % mod) - (b % mod) + mod) % mod;
    }
    private static long mul(long a, long b) {
        long mod = 1000000007;
        return ((a % mod) * (b % mod) + mod) % mod;
    }

    public String shortestPalindrome(String s) {
        long FH = 0, BH = 0;
        long p = 31;
        long maxPower = 1;
        int len = 0;
        for(int i = 0; i < s.length(); i++) {
            // FH = FH*p+c
            FH = add(mul(FH , p) , s.charAt(i) - 'a'+1);
            //BH = BH + c * p^max
            BH = add(BH, mul(s.charAt(i) - 'a'+1, maxPower));
            if(FH == BH) {
                len = i+1;
            }
            maxPower = mul(maxPower,p);
        }
        String st = s.substring(len);
        return new StringBuilder(st).reverse().toString() + s;
    }
}