class MedianFinder {
    PriorityQueue<Integer> min, max;
    public MedianFinder() {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int x) {
        if(max.size() > 0  && (int) max.peek() > x) max.add(x);
        else min.add(x);
        balanceHeap();
    }
    private void balanceHeap() {
        if(min.size() - max.size() > 1) max.add(min.poll());
        else if(max.size() - min.size() > 1) min.add(max.poll());
        else {}
    }
    public double findMedian() {
        if(min.size() > max.size()) return  (double) min.peek();
        else if(min.size() < max.size()) return (double) max.peek();
        else return ((double) min.peek() + (double) max.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */