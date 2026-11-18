class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int fs1[] = new int[26];

        for(int j = 0; j < s1.length(); j++) {
            char cj = s1.charAt(j);
            fs1[cj-'a']++;
        }
        int fs2[] = new int[26];
        int i = 0, k = s1.length();

        for(int j = 0; j < s2.length(); j++) {
            char cj = s2.charAt(j);
            fs2[cj-'a']++;

            if(j-i+1 == k) {
                if(Arrays.equals(fs1,fs2))  return true;
                
                char ci = s2.charAt(i);
                fs2[ci-'a']--;
                i++;
            }
        }
        return false;
    }
}