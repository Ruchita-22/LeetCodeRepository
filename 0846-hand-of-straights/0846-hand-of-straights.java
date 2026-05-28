class Solution {
    
    public boolean isNStraightHand(int[] nums, int k) {
        var map = new TreeMap<Integer, Integer>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        System.out.println(map);
        while(!map.isEmpty()) {

            int first = map.firstKey();
            // try to create consecutive group
            for(int i = first; i < first + k; i++) {

                if(!map.containsKey(i)) {
                    return false;
                }

                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
        return true;
    }

}