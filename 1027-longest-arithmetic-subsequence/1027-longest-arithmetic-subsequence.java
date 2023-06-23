class Solution {
    public int longestArithSeqLength(int[] arr) {
       int n = arr.length;
       HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
       for(int i = 0; i < n; i++) 
			map.put(i, new HashMap<>());
       int max = 2;
       for(int e = 1; e < n; e++) {  
           for(int s = 0; s <e; s++) {
             int diff = arr[e] - arr[s];
             map.get(e).put(diff, map.get(s).getOrDefault(diff, 1)+1);
             max = Math.max(max, map.get(e).get(diff));
           }  
         }
       return max;
    }
}