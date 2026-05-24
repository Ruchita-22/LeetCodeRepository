class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length())   return new ArrayList();

        int fs1[] = new int[26];
        int fs2[] = new int[26];

        for(char c : p.toCharArray()) {
            fs1[c-'a']++;
        }

        int i = 0, k = p.length();
        List<Integer> list=  new ArrayList<>();

        for(int j = 0; j < s.length(); j++) {
            //add nums[i]
            char cj = s.charAt(j);
            fs2[cj-'a']++;
            
            if((j-i+1) == k) {
                // calculation ans
                if(Arrays.equals(fs1,fs2))   list.add(i);

                // remove nums[i]
                char ci = s.charAt(i);
                fs2[ci-'a']--;
                i++;
            }
        }
        return list;

    }
}