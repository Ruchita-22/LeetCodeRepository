class Solution {
    public int numIdenticalPairs(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        int count = 0;
        for(int e : arr){
            if(map.containsKey(e)){
                count += map.get(e);
            }
            map.put(e, map.getOrDefault(e,0)+1);
        }
        return count;
    }
}