class MedianFinder {
    PriorityQueue<Integer> min, max;
    public MedianFinder() {
        min = new PriorityQueue();
        max = new PriorityQueue(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(max.size() > 0 && max.peek() >= num) max.add(num); 
        else min.add(num);

        if(max.size() - min.size() > 1) min.add(max.poll());
        else if(min.size() - max.size() > 1) max.add(min.poll());
        else {}
    }
    
    public double findMedian() {
        return max.size() == min.size() ? 
        (max.peek()+min.peek())/2.0 : 
        (max.size() > min.size() ? max.peek() : min.peek());
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */