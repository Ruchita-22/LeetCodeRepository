class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
        int i = 0, j = 0, freq = 0, len = Integer.MAX_VALUE;
        String res = null;
        while(j < s.length()) {
            char cj = s.charAt(j);
            if(cj == '1') freq++;
            if(freq == k) {
//                 if(len > j-i+1) {
//                     len = j-i+1;
//                     res = s.substring(i,j+1);
//                 } else if(len == j-i+1) {
//                     // check lexog smaller
//                 } else {
                    
//                 }
                while(freq == k) {
                    if(len > j-i+1) {
                        len = j-i+1;
                        res = s.substring(i,j+1);
                    } else if(len == j-i+1) {
                        // check lexog smaller
                        res = lexograpicallySmaller(res,  s.substring(i,j+1));
                        
                    } else {
                        
                    }
                    char ci = s.charAt(i);
                    if(ci == '1') freq--;
                    i++;
                }
                
            }
            
            j++;
        }
        return res == null ? "" : res;
    }
    public String lexograpicallySmaller(String str1, String str2) {
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (char1 < char2) {
                return str1;
            } else if (char1 > char2) {
                return str2;
            }
        }

        // If one string is a prefix of the other, the shorter one is smaller
        if (str1.length() < str2.length()) {
            return str1;
        } else if (str1.length() > str2.length()) {
            return str2;
        }

        // If both strings are identical, return any of them
        return str1;
    }
}