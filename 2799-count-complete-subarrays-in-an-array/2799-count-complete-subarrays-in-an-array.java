class Solution {
    public int countCompleteSubarrays(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        
        for(int e : arr)    set.add(e);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int i = 0, j = 0, count = 0;
        
        while(j < arr.length){
            int ej = arr[j];
            map.put(ej, map.getOrDefault(ej, 0)+1);
            
            if(map.size() < set.size()) j++;
            
            else if(map.size() == set.size()){
                while(i <= j && map.size() == set.size()){
                    count += n-1-j+1;
                    int ei = arr[i];
                    map.put(ei, map.getOrDefault(ei, 0)-1);
                    if(map.get(ei) == 0)    map.remove(ei);
                    i++;
                }
                j++;   
            }
           // j = Math.max(i,j);
        }
        return count;
        
    }
}

// set 1 3 2
/* map 
1 - 2
3 - 1
2 - 1

*/
