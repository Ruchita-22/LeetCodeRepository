class Solution {
    public long repairCars(int[] ranks, int cars) {
        long minTime = 1, maxTime = Integer.MAX_VALUE;
        int maxRank = 0;
        for(int rank : ranks) {
            maxRank = Math.max(maxRank,rank);
        }
        maxTime = maxRank *1L * cars * cars;

        long s =  minTime, e = maxTime;
        long ans = 0;
        while(s <= e) {
            long m = s + (e-s)/2;
            if(isPossible(ranks, m, cars)) {
                ans = m;
                e = m-1;
            } else {
                s = m+1;
            }
        }
        
        return ans;
    }

    // time = r * n*n
    // time/r = n^2
    private boolean isPossible(int[] nums, long m, int k) {
        long totalCar = 0;
        for(int num : nums) {
            totalCar += Math.sqrt((double)m/num );
        }
        return totalCar >= k ? true : false;
    }
}