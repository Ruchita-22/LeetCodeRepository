class Solution {
public String reorganizeString(String s) {
        var map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
            if(map.get(c) > Math.ceil(s.length()*1.0/2)) {
                return "";
            }    
        }

        var pq = new PriorityQueue<Character>((o1,o2) -> map.get(o2) - map.get(o1));
        for(char c : map.keySet()) {
            pq.add(c);
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size() >= 2) {

            Character key1 = pq.poll();
            Character key2 = pq.poll();
            sb.append(key1);
            sb.append(key2);

            map.put(key1, map.get(key1)-1);
            map.put(key2, map.get(key2)-1);


            if(map.get(key1) == 0)   map.remove(key1);
            else pq.add(key1);
             if(map.get(key2) == 0)   map.remove(key2);
            else pq.add(key2);
        }
        if(pq.size() > 0) sb.append(pq.poll());
        return sb.toString();
    }
}