class Solution {
    public List<Integer> partitionLabels(String s) {
        var map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            map.put(ci,i);
        }
        System.out.println(map);

        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            int e = map.get(s.charAt(i));
            for (int j = i+1; j < e; j++) {
                if(map.get(s.charAt(j)) > e) {
                    e = map.get(s.charAt(j));
                }    
            }
            list.add(e-i+1);
            i = e+1;
        }
        return list;
    }
}