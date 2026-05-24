class Solution {
    public String minWindow(String s, String p) {
        if(s.length() < p.length())     return "";

        var map = new HashMap<Character,Integer>();
        for(char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int i = 0;
        int useful = 0, len = Integer.MAX_VALUE, idx = 0;

        for(int j = 0; j <s.length(); j++) {
            char cj = s.charAt(j);

            if(map.containsKey(cj)) {
                map.put(cj, map.get(cj)-1);
                if(map.get(cj) >= 0)    useful++;
            }

            while(useful == p.length()) {
                if(len >  j-i+1) {
                    len = j-i+1;
                    idx = i;
                }
                // remove effect of i
                char ci = s.charAt(i);
                if(map.containsKey(ci)) {
                    map.put(ci, map.get(ci)+1);
                    if(map.get(ci) > 0)    useful--;
                }
                i++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(idx, idx + len);
        
    }
}