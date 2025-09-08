class Solution {
    public long wonderfulSubstrings(String word) {
        int currXor = 0;
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(char ch : word.toCharArray()) {
            int charIdx = ch-'a';
            currXor ^= 1<<charIdx;
            count += map.getOrDefault(currXor,0);
            for(int i = 0; i < 10; i++) {
                count += map.getOrDefault(currXor ^ (1<<i),0);
            }
            map.put(currXor, map.getOrDefault(currXor, 0)+1);
        }
        return count;
    }
}