class Solution {
 
    public String shortestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "$" + rev;
        int[] z = zFunction(temp);

        int longestPalPrefix = 0;

        for (int i = 0; i < temp.length(); i++) {
            if (i + z[i] == temp.length()) {
                longestPalPrefix = Math.max(longestPalPrefix, z[i]);
            }
        }

        String suffix = s.substring(longestPalPrefix);

        return new StringBuilder(suffix).reverse().toString() + s;
    }

    private int[] zFunction(String s) {

        int n = s.length();
        int[] z = new int[n];

        int l = 0;
        int r = 0;

        for (int i = 1; i < n; i++) {

            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            while (i + z[i] < n &&
                   s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        return z;
    }
}