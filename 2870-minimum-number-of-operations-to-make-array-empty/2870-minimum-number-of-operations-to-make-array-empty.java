class Solution {
    public int minOperations(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for(int e : arr){
            map.put(e, map.getOrDefault(e,0)+1);
        }
        int op = 0;
       
        for(int val : map.values()) {
           if(val == 1) return -1;
           op += Math.ceil((double)val/3);
        }
        return op;
    }
}

/*
*Only positive numbers
length cant be 0  */