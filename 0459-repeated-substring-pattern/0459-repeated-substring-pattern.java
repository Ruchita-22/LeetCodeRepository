class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();
        int[] z = getZarr(s);

        for(int i = 1; i < n; i++) {

            if(i + z[i] == n && n % i == 0) {
                return true;
            }
        }

        return false;
    }
    /// //////////Helper////////////////////
    private static int[] getZarr(String s) {
        int z[] = new int[s.length()];
        int l = 0, r = 0;

        for(int i = 1; i < s.length(); i++) {
            if(i <= r) {
                z[i] = Math.min(r-i+1,z[i-l]);
            }
            while(i + z[i] <  s.length() && s.charAt(z[i]) == s.charAt(i+z[i])) {
                z[i]++;
            }
            if(i + z[i] -1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}