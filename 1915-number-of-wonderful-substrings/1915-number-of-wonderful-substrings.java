class Solution {
    public long wonderfulSubstrings(String word) {
        var map = new HashMap<Integer, Integer>();
        map.put(0,1);
        int xor = 0;
        long count = 0;

        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            xor ^= (1<< idx);

            count += map.getOrDefault(xor,0);

            for(int i = 0; i < 10; i++) {
                count += map.getOrDefault(xor ^ (1<<i),0);
            }
            map.put(xor, map.getOrDefault(xor, 0)+1);
        }
        return count;
    }
}