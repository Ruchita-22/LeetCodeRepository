class Solution {
    public int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue();

        for(int num : nums) {
            pq.add(num);

            if(pq.size() > k)   pq.poll();
        }
        return (int)pq.poll();
    }
}