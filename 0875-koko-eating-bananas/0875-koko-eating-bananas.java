class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        long minBanana = 1, maxBanana = 0;
        for(int pile : piles) {
            maxBanana += pile;
        }
        
        long s =  minBanana, e = maxBanana;
        long ans = 0;
        while(s <= e) {
            long m = s + (e-s)/2;
            if(isPossible(piles, m, h)) {
                ans = m;
                e = m-1;
            } else {
                s = m+1;
            }
        }
        
        return (int)ans;
    }
    private boolean isPossible(int[] piles, long m, int h) {
        long totalHour = 0;
        for(int pile : piles) {
            totalHour += Math.ceil((double)pile/m);
        }
        return totalHour <= h ? true : false;
    }
}