class Solution {
    
    public int minCost(String colors, int[] neededTime) {
        int i = 0, j = 1;
        int totalTime = 0;
        while(j < neededTime.length) {
            if(colors.charAt(i) == colors.charAt(j)) {
                if(neededTime[i] <= neededTime[j]) {
                    totalTime += neededTime[i];
                    i = j;
                    j++;
                } else {
                    totalTime += neededTime[j];
                    j++;
                }
            } else {
                i = j;
                j++;
            }
            
        }
        return totalTime;
    }
}    