//https://www.youtube.com/watch?v=clHTLCrl7eM
// cost == freq
/*
create pair and sort

*/
class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        ArrayList<Pair> list = new ArrayList<>();
        long total_elements = 0;
        for(int i = 0; i < n; i++){
            list.add( new Pair(nums[i], cost[i]) );
            total_elements += cost[i];
        }
        
        Collections.sort(list, (o1,o2) -> o1.x != o2.x ? o1.x - o2.x : o1.y-o2.y);
        
        total_elements = total_elements %2 == 0 ?  total_elements/2 : total_elements/2 + 1;
        long mid = 0;
        int i=0;
        
        while(i < n && mid < total_elements){
            mid +=  list.get(i).y;
            i++;
        }
        int center = list.get(i-1).x;
        long total_cost = 0;
        for(Pair p : list){
            total_cost += ( Math.abs(p.x - center) * 1L * p.y);
        }
        return total_cost;
        
    }
}
