class Solution {
    public int halveArray(int[] nums) {
        var pq = new PriorityQueue<Double>(nums.length, Collections.reverseOrder());
        double sum = 0;
        for(int e : nums) {
            pq.add((double)e);
            sum += e;
        }
        double currSum = sum;
        int k = 0;
        while(currSum > sum/2.0) {
            k++;
            double e = pq.poll();
            currSum = currSum - e + (e/2.0);
            e = e/2.0;
            pq.add(e);
        }
        return k; 
    }
}