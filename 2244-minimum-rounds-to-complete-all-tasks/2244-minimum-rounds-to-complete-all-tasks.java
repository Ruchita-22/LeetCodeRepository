class Solution {
    public int minimumRounds(int[] tasks) {
        var map = new HashMap<Integer, Integer>();

        for(int num : tasks) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        System.out.println(map);
        int op = 0;
        for( int key : map.keySet()) {
            int freq = map.get(key);
            if(freq == 1) return -1;
            op += Math.ceil((double)freq/3);
        }
        return op;
    }
}