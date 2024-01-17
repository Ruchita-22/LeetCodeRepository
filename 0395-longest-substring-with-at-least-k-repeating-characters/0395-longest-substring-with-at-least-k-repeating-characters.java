class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0 || k > s.length())    return 0;
        if(k < 2 )  return s.length();
        
        int freq[] = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c-'a']++;
        }
        
        int l = 0;
        while(l < s.length() && freq[s.charAt(l)-'a'] >= k) l++;
        if(l >= s.length()-1) return l;

        int ls1 = longestSubstring(s.substring(0, l), k);
        while(l < s.length() && freq[s.charAt(l)-'a'] < k) l++;
        int ls2 = (l < s.length()) ? longestSubstring(s.substring(l), k) : 0;
        return Math.max(ls1, ls2);
        
    }
   
}