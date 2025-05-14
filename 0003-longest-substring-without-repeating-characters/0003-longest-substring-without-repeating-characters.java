class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0, j =0;
        int len = 0;
        while(j < s.length()) {
            char cj = s.charAt(j);
            if(!set.contains(cj)) {
                set.add(cj);
                len = Math.max(len, j-i+1);
                j++;
            } else {
                while(set.contains(cj)) {
                    char ci = s.charAt(i);
                    set.remove(ci);
                    i++;
                }
            }
        }
        return len;
        
    }
}