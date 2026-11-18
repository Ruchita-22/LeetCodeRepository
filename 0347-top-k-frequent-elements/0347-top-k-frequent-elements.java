class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2) -> !map.get(o1).equals(map.get(o2)) ? map.get(o1) - map.get(o2) : map.get(o2) - map.get(o1) );

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(Integer num : map.keySet()) {
            pq.add(num);

            if(pq.size() > k)   pq.poll();
        }
        return pq.stream().mapToInt(Integer :: intValue).toArray();
    }
}