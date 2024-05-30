class Solution {
    public int countTriplets(int[] arr) {
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            for(int k = i+1; k < arr.length; k++) {
                if((val ^= arr[k]) == 0)
                    ans += (k-i);
            }
        }
        return ans;
    }
}