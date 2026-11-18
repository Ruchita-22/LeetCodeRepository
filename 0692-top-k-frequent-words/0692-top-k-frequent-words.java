class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap();
        PriorityQueue<String> pq = new PriorityQueue<String>((a, b) -> Integer.compare(map.get(a), map.get(b)) != 0  ?  Integer.compare(map.get(a), map.get(b)) : b.compareTo(a) );

        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        for(String word : map.keySet()) {
            pq.add(word);

            if(pq.size() > k)   pq.poll();
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.reverse(result);

        return result;
    }
}