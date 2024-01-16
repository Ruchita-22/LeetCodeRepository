class Solution {
    public int sumIndicesWithKSetBits(List<Integer> arr, int k) {
        int sum = 0;
        
        for(int i = 0; i < arr.size(); i++) {
            if(countSetBit(i) == k) sum += arr.get(i);
            
        }
        return sum;
    }
    public int countSetBit(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if( ((n>>i) & 1) == 1 ) count++;
        }
        return count;
    }
}