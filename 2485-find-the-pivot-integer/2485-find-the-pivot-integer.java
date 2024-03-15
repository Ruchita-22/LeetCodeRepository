class Solution {
    
    public int pivotInteger(int n) {
        /*
        sum(1-x) = sum(x-n)
        x*(x+1)/2 = n(n+1)/2 - x(x+1)/2 + x
        x = sqrt(n*(n+1)/2)
        
        */
        double a = n*(n+1)/2;
        a = Math.sqrt(a);
        //System.out.println(a % 1 == 0.0);
        
        if(a - Math.ceil(a) == 0)  return (int) a;
        else return -1;
        /*
        // approach 1
        if(n == 1)  return 1;
        long sumL = 0, sumR = 0;
        
        sumR = n*(n+1)/2;
        
        for(int i = 1; i <= n; i++) {
            sumL += i;
            if(sumL == sumR-sumL+i)    return i;
        }
        return -1;
        */
   
        
        /* // prefix sum
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
        */
        
        
        
        
    }
}