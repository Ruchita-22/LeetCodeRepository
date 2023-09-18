class Solution {
    public int lengthOfLongestSubstring(String s) {
        //if(s == null || s.length() == 0)    return 0;
        HashSet<Character> set = new HashSet<>();
        
        int i = 0, j = 0, len = 0;
        
        while(j < s.length()){
            char cj = s.charAt(j);
            
            if(!set.contains(cj)){
                set.add(cj);
                len = Math.max(len, j-i+1);
                j++;
            }
            else {
                while(set.contains(cj)){
                    char ci = s.charAt(i);
                    set.remove(ci);
                    i++;
                }
                set.add(cj);
                len = Math.max(len, j-i+1);
                j++;
            }
        }
        return len;
    }
}