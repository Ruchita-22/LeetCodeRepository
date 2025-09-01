class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        //edge case
        if(arr.length < 3)  return ans;

        Arrays.sort(arr);
        for(int i = 0; i < arr.length-2; i++) {
            int a = arr[i];
            int j = i+1 , k = arr.length-1;
            while(j < k){
                int b = arr[j], c = arr[k];
                if(b+c < -a)    j++;
                else if(b+c > -a)   k--;
                else {
                    if(!set.contains(List.of(a,b,c))) {
                        ans.add(List.of(a,b,c));
                        set.add(List.of(a,b,c));
                    }    
                        
                    j++; k--;
                }
            } 
        }
        return ans;

        
    }
}