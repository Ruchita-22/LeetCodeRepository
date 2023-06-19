class Solution {
    public int largestAltitude(int[] arr) {
        int ans=0;
        int pf[] = new int[arr.length+1];
        
        pf[0] = arr[0];
        ans = Math.max(ans,pf[0]);
        for(int i=1;i<arr.length;i++){
            pf[i] = pf[i-1] + arr[i]; 
            ans = Math.max(ans,pf[i]);
        }
        return ans;
    }
    
}
