class Solution {
    int[] parent, rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        int[] parent = new int[n+1];
        for(int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }
        int[] rank = new int[n+1];
        Arrays.fill(rank, 1);
        for(int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            
            int pu = parentCompute(u, parent);
            int pv = parentCompute(v, parent);
            
            if(pu == pv)    return edge;
            else {
                if(rank[pu] > rank[pv]) {
                    parent[pu] = pv;
                } else if(rank[pu] < rank[pv]) {
                    parent[pv] = pu;
                } else {
                     parent[pu] = pv;
                     rank[pv]++;
                }
               
            }
        }
        return new int[2];
        
    }
   
    private int parentCompute(int n, int parent[]) {
        if(parent[n] == n)  return n;
        return parent[n] = parentCompute(parent[n], parent);
    }
}