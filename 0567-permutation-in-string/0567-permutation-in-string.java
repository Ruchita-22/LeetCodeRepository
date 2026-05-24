class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())   return false;

        int fs1[] = new int[26];
        int fs2[] = new int[26];

        for(char c : s1.toCharArray()) {
            fs1[c-'a']++;
        }

        int i = 0, k = s1.length();
        String s = s2;

        for(int j = 0; j < s.length(); j++) {
            //add nums[i]
            char cj = s.charAt(j);
            fs2[cj-'a']++;
            
            if((j-i+1) == k) {
                // calculation ans
                if(Arrays.equals(fs1,fs2))   return true;

                // remove nums[i]
                char ci = s.charAt(i);
                fs2[ci-'a']--;
                i++;
            }
        }
        return false;

    }
}