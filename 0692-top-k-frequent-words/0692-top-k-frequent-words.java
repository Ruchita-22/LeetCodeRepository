class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap();
        PriorityQueue<String> pq = new PriorityQueue<String>((o1,o2) -> !map.get(o1).equals(map.get(o2)) ? map.get(o1) - map.get(o2) : o2.compareTo(o1) );

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