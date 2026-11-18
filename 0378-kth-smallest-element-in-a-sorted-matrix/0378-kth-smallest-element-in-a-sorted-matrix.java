class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i = 0;i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);

                if(pq.size() > k)   pq.poll();
            }
        }
        //System.out.println(pq);

        return pq.poll();
    }
}