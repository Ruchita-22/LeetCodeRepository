class Solution {
    public static HashMap<String, Integer> strFreq;
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        strFreq = new HashMap<>();
        solve(s,maxLetters,minSize);
        // for(int k = minSize; k <= maxSize; k++) {
        //     solve(s,maxLetters,k);
        // }

        int max = 0;
        for(Integer i : strFreq.values()) {
            max = Math.max(max,i);
        }
        return max;
    }
    public static void solve (String s, int maxLetters, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        for(j = 0; j < k; j++) {
            char cj = s.charAt(j);
            map.put(cj, map.getOrDefault(cj,0)+1);
        }
        if(map.size() <= maxLetters) {
            String key = s.substring(i,j);
            strFreq.put(key, strFreq.getOrDefault(key,0)+1);
        }
        // System.out.println("i="+i+" j="+j);
        // System.out.println(strFreq);


        while(j < s.length()) {
            
            char ci = s.charAt(i);
            char cj = s.charAt(j);

            map.put(cj, map.getOrDefault(cj,0)+1);

            map.put(ci, map.get(ci)-1);
            if(map.get(ci) == 0)
                map.remove(ci);
            i++;
            j++;

            if(map.size() <= maxLetters) {
                String key = s.substring(i,j);
                strFreq.put(key, strFreq.getOrDefault(key,0)+1);
            }           
        }
        
        //System.out.println(strFreq);
        
    }
}