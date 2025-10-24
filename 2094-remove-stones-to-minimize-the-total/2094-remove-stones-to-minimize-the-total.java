class Solution {
    public int minStoneSum(int[] piles, int k) {
        var pq = new PriorityQueue<Integer>(piles.length,Collections.reverseOrder());
        
        for(int e : piles)  pq.add(e);

        while(k > 0) {
            int e  = pq.poll().intValue();
            e -= Math.floor(e/2);
            pq.add(e);
            k--;
        }
        int ans = 0;
        while(pq.size() > 0) {
            ans += pq.poll();
        }
        return ans;
        
    }
}