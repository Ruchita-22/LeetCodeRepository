class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for(int e : arr) {
            map.put(e, map.getOrDefault(e,0)+1);
        }
        Set<Integer> set = new HashSet();
        for(Integer e : map.values()) {
            if(set.contains(e)) return false;
            set.add(e);
        }
        return true;
    }
}