class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        int fs1[] = new int[26]; 
        int fs2[] = new int[26]; 
        for(char c : p.toCharArray()) {
            fs1[c-'a']++;
        }

        int i = 0, j = 0;
        for( j = 0; j < p.length(); j++) {
            char c = s.charAt(j);
            fs2[c-'a']++;
        }
        if(Arrays.equals(fs1,fs2)) list.add(i);

        while(j < s.length()) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            fs2[ci-'a']--;
            fs2[cj-'a']++;
            i++; j++;
            if(Arrays.equals(fs1,fs2)) list.add(i);
        }
        return list;
        
        
    }
}