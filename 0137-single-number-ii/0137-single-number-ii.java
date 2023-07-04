class Solution {
    public int singleNumber(int[] arr) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;
            for(int j = 0; j < arr.length; j++){
                if( checkBit(arr[j],i) )
                    sum++;
            }
            sum = sum % 3;
            if(sum != 0)
                ans = ans | sum << i; 
        }
        return ans;
    }
    private static boolean checkBit(int n, int i){
        return ((n>>i) & 1) == 1 ? true : false;
    }
}