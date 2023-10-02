class Solution {
    public int[] frequencySort(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e : arr){
            map.put(e,map.getOrDefault(e,0)+1);
            
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> 
            map.get(n1) != map.get(n2) ?                                            
           map.get(n1) - map.get(n2) : n2-n1);
        
		for (int n1 : map.keySet()) pq.add(n1);
		
		int i=0;
		while (pq.size() > 0) {
			int n = pq.poll();
			int f = map.get(n);
			while(f>0){
                arr[i] = n;
                i++;
                f--;
            }
			
		}
        return arr;
    }
}