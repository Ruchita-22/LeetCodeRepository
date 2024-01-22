class Solution {
    public int[] findErrorNums(int[] arr) {
        int xor = 0;
        for(int e : arr)    xor ^= e;
        for(int i = 1; i <= arr.length; i++) xor ^= i;
        int pos = -1;
        for(int i = 31; i >= 0; i--) {
            if(((xor >> i) & 1) == 1) {
                pos= i;
                break;
            }
        }
        int set = 0, unset = 0;
        for(int e : arr)    {
            if(((e >> pos) & 1) == 1)   set ^= e;
            else unset ^= e;
        }
        for(int i = 1; i <= arr.length; i++) {
            if(((i >> pos) & 1) == 1)   set ^= i;
            else unset ^= i;
        }
        boolean flag = false;
        
        int res[] = new int[2];
        for(int e : arr) {
            if(e == unset) {
                res[0] = unset;
                flag = true;
            }
        }
        if(flag == false) {
            res[0] = set;
            res[1] = unset;
        } else {
            res[1] = set;
        }
        return res;
    }
}