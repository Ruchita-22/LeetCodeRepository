class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> {
                int freq = Integer.compare(map.get(a),map.get(b));
                if(freq == 0)   return Integer.compare(a,b);
                return freq;
            }
        );

        for(Integer key : map.keySet()) {
            pq.add(key);
            if(pq.size() > k)   pq.poll();
        }
        return pq.stream().mapToInt(Integer :: intValue).toArray();
    }
}