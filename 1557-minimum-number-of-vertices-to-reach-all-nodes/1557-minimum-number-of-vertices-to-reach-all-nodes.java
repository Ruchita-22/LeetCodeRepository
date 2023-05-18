class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        //construct graph
        
        int inDegree[] = new int[n];
        
        for(int i=0;i<edges.size();i++){
            int src = edges.get(i).get(0);
            int des = edges.get(i).get(1);
            inDegree[des]++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0)
                res.add(i);
            
        }
        return res;
        
        
        
    }
    
    
}

/*
BFS will not work here as it will not give the min
*/
