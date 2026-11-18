class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1,o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        List<int[]> res = new ArrayList();
        res.add(intervals[0]);

        for(int j = 1; j < intervals.length; j++) {
            int[] oldInterval = res.get(res.size()-1);
            if(oldInterval[1] < intervals[j][0]) {
                res.add(intervals[j]);
            } else if(oldInterval[1] >= intervals[j][0]) {
                oldInterval[0] = Math.min(oldInterval[0], intervals[j][0]);
                oldInterval[1] = Math.max(oldInterval[1], intervals[j][1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}