class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];

        // sort
        Arrays.sort(intervals, (o1,o2)-> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        
        ArrayList<int[]> res = new ArrayList();
        res.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++) {

            int[] oldInterval = res.get(res.size()-1);
            if(oldInterval[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else if(oldInterval[1] >= intervals[i][0]) {
                oldInterval[0] = Math.min(oldInterval[0], intervals[i][0]);
                oldInterval[1] = Math.max(oldInterval[1], intervals[i][1]);
            }
            
        }
        return res.toArray(new int[res.size()][]);
    }
}
