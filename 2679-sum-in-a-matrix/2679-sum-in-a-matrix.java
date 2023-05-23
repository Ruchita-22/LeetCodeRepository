class Solution {
    public int matrixSum(int[][] arr) {
        
        ArrayList<PriorityQueue<Integer>> list = new ArrayList<>();
        
        
        
        for(int i=0;i<arr.length;i++){
            
            // for each row create a pq and add element of that row in pq
            list.add(i, new PriorityQueue<Integer>((o1,o2)-> o2-o1));
            PriorityQueue<Integer> pq = list.get(i);
            
            for(int j=0;j<arr[0].length;j++){
                pq.add(arr[i][j]);
            }
        }
        
        int ans = 0;
        
        for(int i=0;i<arr[0].length;i++){
            
            PriorityQueue<Integer> mainPq = new PriorityQueue<>((o1,o2)-> o2-o1);
            // for each rol get max element from pq and remove it and add in main  pq 
            for(int j=0;j<arr.length;j++){
                mainPq.add(list.get(j).poll());
            }
            // get max of all max of all row in ith iteration add in ans
            ans += mainPq.poll();
        }
        return ans;
    }
}