class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour <= dist.length - 1) return -1;
        //d= s*t;
        //s= d/t;
        int minSpeed = 1, maxSpeed = 10000000;
        // long totalDistance = 0;
        // for(int dis : dist) {
        //     totalDistance += dis;
        // }
        // minSpeed = (int)(totalDistance/hour);

        int s = minSpeed, e = maxSpeed;
        int ans = 0;
        while(s <= e) {
            int m = s+(e-s)/2;
            
            if(isPossible(dist, m, hour )) {
                ans = m;
                e = m-1;
            } else {
                s = m+1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[] dist, int m, double hour) {
        double totalTime = 0;
        for(int i = 0; i < dist.length-1; i++) {
            totalTime += Math.ceil((double)dist[i]/m);
        }
        totalTime += ((double)dist[dist.length-1]/m);
        return totalTime <= hour ? true : false;
    }
}