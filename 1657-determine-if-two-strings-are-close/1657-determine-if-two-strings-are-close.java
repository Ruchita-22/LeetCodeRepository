class Solution {
    public boolean closeStrings(String s1, String s2) {
        if(s1 == null && s2 == null)    return true;
        if(s1 == null || s2 == null)    return false;
        if(s1.length() != s2.length())  return false;
        
        int fs1[] = new int[26];
        int fs2[] = new int[26];
        for(char c : s1.toCharArray()) {
            fs1[c-'a']++;
        }
        for(char c : s2.toCharArray()) {
            fs2[c-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(fs1[i] != 0 && fs2[i] == 0)  return false;
            if(fs2[i] != 0 && fs1[i] == 0)  return false;
        }
        Arrays.sort(fs1);
        Arrays.sort(fs2);
        return Arrays.equals(fs1, fs2) ? true : false;
    }    
    
    // with the below approach only 132 test case are passed/
    //so we need new solution
   /*
   public boolean closeStrings(String s1, String s2) {
        if(s1 == null && s2 == null)    return true;
        if(s1 == null || s2 == null)    return false;
        if(s1.length() != s2.length())  return false;
        
        HashSet<Character> set1 = new HashSet();
        HashSet<Character> set2 = new HashSet();
        
        for(char c : s1.toCharArray()) {
            set1.add(c);
        }
        for(char c : s2.toCharArray()) {
            set2.add(c);
        }
        return set1.equals(set2) ? true : false;
        
        
        
    }*/
}