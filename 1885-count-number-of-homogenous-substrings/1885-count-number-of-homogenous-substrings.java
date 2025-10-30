class Solution {
    public int countHomogenous(String s) {
        int mod = 1000000007;
        int j = 0;
        int len = 0;
        int ans = 0;
        while(j < s.length()) {
            if(j > 0 && s.charAt(j) == s.charAt(j-1)) {
                len++;
                ans = (ans % mod +  len % mod) % mod;
            } else {
                len = 1;
                ans = (ans % mod +  len % mod) % mod;
            }
            //System.out.println(s.charAt(j) +" " + len+ " "+ ans);
            j++;
        }
        return ans;
        
    }
}