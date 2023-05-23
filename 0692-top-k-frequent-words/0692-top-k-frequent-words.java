class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String , Integer> map = new HashMap<>();
        
        for(String s : words){
            map.put(s, map.getOrDefault(s,0)+1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>(k,(o1,o2)->
            (int)map.get(o1)!=map.get(o2) ? map.get(o1)-map.get(o2): o2.compareTo(o1)
        );
        
        for(String s : map.keySet()){
            pq.add(s);
            while(pq.size()>k)
                pq.poll();
        }
        
        
        List<String> list = new ArrayList();
        while(pq.size()>0){
            list.add(0,pq.poll());
        }
        return list;
    }
}