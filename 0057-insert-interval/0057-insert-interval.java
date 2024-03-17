class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
    
        ArrayList<int[]> list  = new ArrayList<>();
        if(intervals.length==0) {
            list.add(newInterval);
            return list.toArray(new int[list.size()][]);
        }
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0] > newInterval[1]) {
                list.add(newInterval);
                while(i<intervals.length){
                    list.add(intervals[i]);
                    i++;
                }
                return list.toArray(new int[list.size()][]);
            }
            else if(intervals[i][1]< newInterval[0]) list.add(intervals[i]);
            else {
                newInterval[0] = Math.min(intervals[i][0] , newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1] , newInterval[1]);
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}