
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1,o2)-> {
            if(o1[0]==o2[0])    return 0;
            else if(o1[0]>o2[0])    return 1;
            else return -1;
        });
        
        int last = points[0][1];
        int ans = 1;
        for(int i=1;i<points.length;i++){
            if(last<points[i][0]){
                ans++;
                last = points[i][1];
               
            }
            last = Math.min(last,points[i][1]);
        }    
        return ans; 
    }
}