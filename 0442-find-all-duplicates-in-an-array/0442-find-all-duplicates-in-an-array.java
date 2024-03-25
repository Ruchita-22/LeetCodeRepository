class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet();
        List<Integer> list = new ArrayList<>();
        for(int e : arr) {
            if(set.contains(e)) {
                list.add(e);
            } 
            set.add(e);
        }
        return list;
        
    }
}