class Solution {
    public int halveArray(int[] nums) {
        double sum = 0;
        var pq = new PriorityQueue<Double>(Collections.reverseOrder());

        for(int num : nums) {
            sum += num;
            pq.add(num*1.0);
        }
        //System.out.println(pq);
        double targetSum = 0;
        int count = 0;

        while(targetSum < sum/2) {
            double num = pq.poll();
            num = num/2;
            targetSum += num;
            pq.add(num);
            count++;
        }
        return count;
        
        

    }
}