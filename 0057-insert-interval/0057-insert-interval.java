class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        if(intervals.length == 0)    return new int[][]{newInterval};
        
        ArrayList<int[]> list = new ArrayList();
        int i = 0;

        for(i = 0; i < intervals.length; i++) {

            if(intervals[i][1] <  newInterval[0]) {
                list.add(intervals[i]);
            } else if(intervals[i][0] > newInterval[1] ) {
                //list.add(newInterval);
                break;
            } else if(intervals[i][1] >=  newInterval[0]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);

            }
        }
        list.add(newInterval);
        while(i < intervals.length) {
            list.add(intervals[i++]);
        }
        return list.toArray(new int[list.size()][]);
    }
}