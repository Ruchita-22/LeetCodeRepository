class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        return Arrays.stream(arr)
                .boxed() // Convert int to Integer
                .collect(Collectors.groupingBy(i -> i, Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // Filter duplicates
                .map(Map.Entry::getKey) // Get the duplicate keys
                .collect(Collectors.toList()); // Collect duplicates as a list

//         HashSet<Integer> set = new HashSet();
//         List<Integer> list = new ArrayList<>();
//         for(int e : arr) {
//             if(set.contains(e)) {
//                 list.add(e);
//             } 
//             set.add(e);
//         }
    
//         return list;
        
    }
}