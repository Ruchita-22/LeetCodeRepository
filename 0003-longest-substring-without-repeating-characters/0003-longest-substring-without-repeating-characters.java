class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, ans = 0;
        for(int j = 0; j < s.length(); j++) {

            char cj = s.charAt(j);

            while(set.contains(cj)) {
                // remove nums[i]
                char ci = s.charAt(i);
                set.remove(ci);
                i++;
            }
            set.add(cj);
            ans = Math.max(ans, j-i+1);
        }
        return ans;
    }
}