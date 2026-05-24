class Solution {
    public int countGoodSubstrings(String s) {
        return solve(s,3);
    }
    public int solve (String s, int k) {
        int i = 0, ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int j = 0; j < s.length(); j++) {
            // add j
            char cj = s.charAt(j);
            map.put(cj, map.getOrDefault(cj,0)+1);

            if((j-i+1) == k) {
                // calculation ans
                if(map.size() == k) ans++;

                // remove nums[i]
                char ci = s.charAt(i);
                map.put(ci, map.get(ci)-1);
                if(map.get(ci) == 0) map.remove(ci);

                i++;
            }
        }
        return ans;
    }
}