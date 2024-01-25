class Solution {
    public int hardestWorker(int n, int[][] logs) {
        if(logs.length == 0)    return -1;
        int ansEmpId = logs[0][0] , ansTime = logs[0][1];
        int currTime = logs[0][1];
        
        for(int i = 1; i < logs.length; i++){
            if(logs[i][1] - currTime > ansTime) {
                ansTime = logs[i][1] - currTime;
                ansEmpId = logs[i][0];
            } else if(logs[i][1] - currTime == ansTime) {
                ansEmpId = Math.min(ansEmpId, logs[i][0]);
            }
            currTime = logs[i][1];
        }
        
        return ansEmpId;
    
    }

}