class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())   return false;

        int fs1[] = new int[26];
        int fs2[] = new int[26];
        
        for(char c : s1.toCharArray()) fs1[c-'a']++;

        int i = 0, j = 0;
        for(j = 0; j < s1.length(); j++) { 
            char cj = s2.charAt(j);
            fs2[cj-'a']++;
        }
        if(Arrays.equals(fs1,fs2))  return true;

        while(j < s2.length()) {
            char ci = s2.charAt(i);
            fs2[ci-'a']--;

            char cj = s2.charAt(j);
            fs2[cj-'a']++;

            if(Arrays.equals(fs1,fs2))  return true;

            i++; j++;
        }
        return false;
        
    }
}