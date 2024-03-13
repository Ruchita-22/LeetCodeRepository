class Solution {
    
    public int pivotInteger(int n) {
        long pfL[] = new long[n+1];
        pfL[1] = 1;
        for(int i = 2; i < n+1; i++){
            pfL[i] = pfL[i-1]+i;
        }
        
        long pfR[] = new long[n+1];
        pfR[n] = n;
        for(int i = n-1; i >= 0; i--){
            pfR[i] = pfR[i+1]+i;
        }
        
        for(int i = 0; i <= n; i++){
            if(pfL[i] == pfR[i])    return i;
            
        }
        return -1;
        
        
        
        
    }
}