class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        long minCandies = 1, maxCandies = 0, sum = 0;
        for(int candie : candies) {
            maxCandies = Math.max(maxCandies, candie);
            sum += candie;
        }
        if(sum < k)  return 0;

        long s = minCandies, e = maxCandies;
        long ans = 0;
        while(s <= e) {
            long m = s + (e-s)/2;
            if(isPossible(candies, m, k)) {
                ans = m;
                s = m+1;
            } else {
                e = m-1;
            }
        }
        return (int)ans;
    }
    private boolean isPossible(int nums[], long m, long k) {
        long totalChildren = 0;
        for(int num : nums){
           totalChildren += num/m;
        }
        return totalChildren >= k ? true : false;
    }
}