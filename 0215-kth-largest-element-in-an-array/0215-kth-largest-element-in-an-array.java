class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int e : nums) {
            pq.add(e);
            if(pq.size() > k)   pq.poll();
            //System.out.println(pq);
        }
        
        return pq.poll();
    }
}