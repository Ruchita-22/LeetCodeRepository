class Solution {
    public int maxFrequencyElements(int[] arr) {
        int maxFreq = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : arr) {
            map.put(e, map.getOrDefault(e,0)+1);
            maxFreq = Math.max(maxFreq, map.get(e));
        }
        int count = 0;
        for(int e : map.keySet()) {
            if(map.get(e) == maxFreq)   count++;
        }
        return count * maxFreq;
        
    }
}