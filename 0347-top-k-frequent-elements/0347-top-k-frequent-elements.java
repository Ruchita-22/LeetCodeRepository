class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int e : arr) {
            map.put(e, map.getOrDefault(e,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, (o1,o2) -> map.get(o1) - map.get(o2));
        
        for(int e  : map.keySet()){
            pq.add(e);
            if(pq.size()>k) 
                pq.poll();
        }
        return pq.stream().mapToInt(Integer :: intValue).toArray();
    }
}