class Solution {
    public List<Integer> findAnagrams(String s1, String s2) {
        if(s1.length() < s2.length())   return new ArrayList();
        
        int fs1[] = new int[26];
        int fs2[] = new int[26];
        
        for(char c : s2.toCharArray())  fs2[c-'a']++;
        
        int k = s2.length();
        
        // first window
        for(int j = 0; j < k; j++){
            char cj = s1.charAt(j);
            fs1[cj - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        
        if(Arrays.equals(fs1,fs2))  list.add(0);
        
        int i = 0, j = k;
        
        // slide and check
        while(j < s1.length()){
            char ci = s1.charAt(i);
            char cj = s1.charAt(j);
            fs1[ci - 'a']--;
            fs1[cj - 'a']++;
            i++; j++;
            if(Arrays.equals(fs1,fs2))  list.add(i);
            
        }
        return list;
        
        
        
        
        
    }
}