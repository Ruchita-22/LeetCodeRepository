class Solution {
    public int[] productExceptSelf(int[] arr) {
        long prod = 1;
        int zero = 0;
        for(int e : arr){
            if(e != 0 )
                prod *= e;
            else zero++;
        }    
        
        int res[] = new int[arr.length];
        
        int i = 0;
        for(int e : arr) {
            if(zero == 0) {
                res[i] = (int)(prod/e);
                i++;
            } else {
                if(zero == 1) {
                    if(e == 0) res[i] = (int)prod;
                    i++;    
                }
            }
        }
        
        return res;
    }
}