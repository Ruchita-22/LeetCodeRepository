class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        if(s.length() == k) return true;

        var map = new HashMap<Character, Integer>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        int count = 0;
        
        for(int val : map.values()) {
            if(val % 2 == 1) count++;
        }
        
        return count > k ? false : true;
    }
}