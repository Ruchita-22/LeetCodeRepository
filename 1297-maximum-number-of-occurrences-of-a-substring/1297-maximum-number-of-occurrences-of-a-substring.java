class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        var map = new HashMap<Character, Integer>();
        var ans = new HashMap<String, Integer>();

        int i = 0, count = 0;

        for(int j = 0; j < s.length(); j++) {
            char cj = s.charAt(j);
            map.put(cj, map.getOrDefault(cj,0)+1);

            while(j-i+1 > minSize) {
                char ci = s.charAt(i);
                map.put(ci, map.get(ci)-1);
                if(map.get(ci) == 0) map.remove(ci);
                i++;
            }
            if(j-i+1 == minSize && map.size() <= maxLetters) {
                String sub = s.substring(i, j + 1);
                ans.put(sub, ans.getOrDefault(sub, 0) + 1);
                count = Math.max(count, ans.get(sub));
            } 
        }
        return count;
    }
}