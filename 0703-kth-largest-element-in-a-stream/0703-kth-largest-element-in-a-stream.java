class KthLargest {
    
    PriorityQueue<Integer> pq;
    
    int k = 0;
    public KthLargest(int k, int[] arr) {
        this.pq = new PriorityQueue<Integer>(k);
        this.k = k;
        for(int e : arr){
            pq.add(e);
            if (pq.size()>k)
                pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size()>k)
            pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */