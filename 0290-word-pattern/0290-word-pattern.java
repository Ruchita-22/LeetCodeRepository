class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        var map1 = new HashMap<Character, String>();
        var map2 = new HashMap<String, Character>();
        String strs[] = s.split(" ");

        if(pattern.length() != strs.length) {
            return false;
        }
        
        for(int i = 0; i < pattern.length(); i++) {
            char key1 = pattern.charAt(i);
            if(map1.containsKey(key1)) {
                String value = map1.get(key1);
                if(!value.equals(strs[i])){
                    return false;
                }

            } else {
                map1.put(key1, strs[i]);
            } 

            String key2 = strs[i];
            if(map2.containsKey(key2)) {
                Character value = map2.get(key2);
                if(!value.equals(pattern.charAt(i))){
                    return false;
                }

            } else {
                map2.put(key2, pattern.charAt(i));
            } 
            
        }
        return true;
    }
}