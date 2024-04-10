class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        
        Map<Integer, Long> map = Arrays
            .stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        

            return map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry :: getKey).mapToInt(x->x).toArray();
              
    }
}