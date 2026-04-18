class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)-> o1[0] != o2[0] ? o1[0]-o2[0] : o1[1]-o2[1]);

        ArrayList<int[]> list  = new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int oldInterval[] = list.get(list.size()-1);
            if(oldInterval[1]<intervals[i][0])  list.add(intervals[i]);
            else{
                oldInterval[0] = Math.min(oldInterval[0] , intervals[i][0]);
                oldInterval[1] = Math.max(oldInterval[1] , intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][]);
        
    }
}