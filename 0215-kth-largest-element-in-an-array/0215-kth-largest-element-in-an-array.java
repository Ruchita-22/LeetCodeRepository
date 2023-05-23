class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        
        for(int e : arr){
            pq.add(e);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
        
    }
}