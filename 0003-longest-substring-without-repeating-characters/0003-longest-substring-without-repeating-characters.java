class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        
        // variable size SW
        Set<Character> set = new HashSet();
        int i = 0, j = 0, ws = 0;
        
        while(j < s.length()) {
            char cj = s.charAt(j);
            if(!set.contains(cj)) {
                set.add(cj); 
                j++;
            } else {
                ws = Math.max(ws, set.size());
                while(set.contains(cj)) {
                    char ci = s.charAt(i);
                    set.remove(ci);
                    i++;
                }
            }
        }
        return Math.max(ws, set.size());
    }
}