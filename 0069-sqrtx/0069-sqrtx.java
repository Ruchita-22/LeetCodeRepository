class Solution {
    public int mySqrt(int x) {
        // create Answer space
        int minSqrt = 1, maxSqrt = x;

        // Binary Search on Answer
        int s = minSqrt, e = maxSqrt;
        int ans = 0;
        while(s <= e) {
            int m = s + (e-s)/2;
            if(m*1L*m <= x) {
                ans = m;
                s = m+1;
            } else {
                e = m-1;
            }
        }
        return ans;
    }
}