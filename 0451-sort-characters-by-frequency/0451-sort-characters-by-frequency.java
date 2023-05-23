class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((o1,o2)-> map.get(o2) - map.get(o1));
        
        for(Character ch : map.keySet()){
            pq.add(ch);
        }
        String res = "";
        while(pq.size()>0){
            char ch = pq.poll();
            int freq = map.get(ch);
            while(freq>0){
                res += ch;
                freq--;
            }
        }             
        return res;                                                  
    }
}