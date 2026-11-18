class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() == 0) return new ArrayList();
        
        String s1 = p, s2 = s;

        int fs1[] = new int[26];

        for(int j = 0; j < s1.length(); j++) {
            char cj = s1.charAt(j);
            fs1[cj-'a']++;
        }
        int fs2[] = new int[26];
        List<Integer> res = new ArrayList();
        int i = 0, k = s1.length();

        for(int j = 0; j < s2.length(); j++) {
            char cj = s2.charAt(j);
            fs2[cj-'a']++;

            if(j-i+1 == k) {
                if(Arrays.equals(fs1,fs2))  res.add(i);
                
                char ci = s2.charAt(i);
                fs2[ci-'a']--;
                i++;
            }
        }
        return res;
    }
}