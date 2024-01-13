class Solution {
    public int minSteps(String s, String t) {
        if(s.length() != t.length())    return -1; 
        
        int fs[] = new int[26];
        for(char c : s.toCharArray()) {
            fs[c-'a']++;
        }
        int count = 0;
        for(char c : t.toCharArray()) {
            if(fs[c-'a'] > 0) {
                fs[c-'a']--;
            } else {
                count++;
            }
        }
        return count;
        
    }
}