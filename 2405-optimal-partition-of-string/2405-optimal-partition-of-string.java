class Solution {
        public int partitionString(String s) {
        var map = new HashMap<Character, Integer>();
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            
            if(map.containsKey(ci)) {
                count++;
                map.clear();
                map.put(ci, i);
            } else {
                map.put(ci, i);
            }
        }
        return map.size() > 0 ? count+1 : count;
    }
}



