class Solution {
    public int lengthOfLongestSubstring(String s) {
        var set = new HashSet<Character>();
        int i = 0, ans = Integer.MIN_VALUE;
        for(int j = 0; j < s.length(); j++) {
            char cj = s.charAt(j);

            while(set.contains(cj)) {
                char ci = s.charAt(i);
                set.remove(ci);
                i++;
            }

            set.add(cj);
            ans = Math.max(ans,set.size());
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}