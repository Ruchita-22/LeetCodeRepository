class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int visited[] = new int[n];         // default value 0
        boolean ans = true;
        for(int i= 0 ;i<n ; i++){
            if(visited[i]==0){
                // boolean tempAns = bfs(i, n,graph,visited);
                // ans = ans && tempAns;
                if(! bfs(i, n,graph,visited))   return false;
            }
        }
        return true;
    }
    
    private static boolean bfs(int s, int n, int[][] graph, int visited[]){
        Queue<Integer> q = new LinkedList<Integer>();
       // System.out.println(s);
        q.add(s);
        visited[s] = 1;
        
        while(q.size()>0){
            int node = q.poll();
            //System.out.println(node);
            int[] adj = graph[node];
            for(int i : adj){
                if(visited[i]==0){
                    q.add(i);
                    visited[i] = -visited[node];
                }
                if(visited[i] == visited[node])    return false;
            }
        }
        return true;
    }
}