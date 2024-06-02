class Solution {
    public int minCostConnectPoints(int[][] arr) {
        int n = arr.length;
        int noOfEdges = n*(n-1)/2;
        noOfEdges = 2*noOfEdges;
        int edges[][] = new int[noOfEdges][3];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int s = i, d = j;
                int cost = Math.abs(arr[i][0]-arr[j][0]) + Math.abs(arr[i][1]-arr[j][1]);
                
                int edge1[] = new int[3];
                edge1[0] = s;
                edge1[1] = d;
                edge1[2] = cost;
                edges[idx] = edge1;
                idx++;
                int edge2[] = new int[3];
                edge2[0] = d;
                edge2[1] = s;
                edge2[2] = cost;
                edges[idx] = edge2;
                idx++;
            }
        }
        
        Arrays.sort(edges, (o1,o2)->o1[2]-o2[2]);
        
//          System.out.println("[");
//         for(int i = 0; i < edges.length; i++) {
//             System.out.print("["+edges[i][0]+","+edges[i][1]+","+edges[i][2]+"]");
//         }           
        
//         System.out.println("]");
        
        int parent[] = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int cost = 0;
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            int pu = parentCompute(u, parent);
            int pv = parentCompute(v, parent);
            if(pu != pv) {
                cost += w;
                parent[Math.max(pu, pv)] = Math.min(pu, pv);
            }
            
            
        }
        return cost;
       
    }
    private static int parentCompute(int n, int parent[]) {
        if(parent[n] == n)  return n;
        return parent[n] = parentCompute(parent[n], parent);
        
    }
}
/*
 n = 5
0-1, 0-2, 0-3, 0-4   
1-2, 1-3, 1-4
2-3, 2-4
3-4    
     4+3+2+1
     
     n(n-1)/2
     5*4/2=10
*/     