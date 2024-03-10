class Solution {
    public int[] intersection(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : arr1) {
            map.put(e, map.getOrDefault(e,0)+1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int e : arr2) {
            if(map.containsKey(e)) {
                 //map.put(e, map.get(e)-1);
               // if(map.get(e) == 0) 
                map.remove(e);
                list.add(e);
            }
        }
        return list.stream().mapToInt(x->x).toArray();
        
    }
}