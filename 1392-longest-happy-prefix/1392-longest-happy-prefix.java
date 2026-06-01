class Solution {
    public String longestPrefix(String s) {
        int z[] = getZarr(s);
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if (i + z[i] == s.length()) {
                ans = Math.max(ans, z[i]);
            }
        }
        return s.substring(0,ans);
        
    }
    private int[] getZarr(String s) {
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