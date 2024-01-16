class Solution {
    public int singleNumber(int[] arr) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;
            for(int j = 0; j < arr.length; j++){
                if(((arr[j]>>i) & 1) == 1)
                    sum++;
            }
            sum = sum % 3;
            if(sum != 0)
                ans |= sum << i; 
        }
        return ans;
    }
    
}